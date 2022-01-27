<CsoundSynthesizer>
<CsOptions>
-W -o ej7.2.wav
</CsOptions>
<CsInstruments>

nchnls = 1  ; sonido en mono
sr = 44100  ; frecuencia de muestreo
ksmps  = 1  ; en cada ciclo de control se calcula una sola muestra

; PARA EL COMPRESOR / LIMITADOR
instr compresor
  SFich   = p4   ; para el nombre del fichero a procesar
  iUmbdB  = p5   ; para el umbral en dBFS enviado desde la partitura
  iRatio  = p6   ; para la tasa de compresion
  iUmbPCM = ampdbfs(p5)     ; calculo del umbral en PCM con ampdbfs()

  prints  "\n"
  print   iUmbdB,iUmbPCM    ; para verificar que esta entre 0 y Amax

  ain soundin SFich         ; leer el fichero sobre ain muestra a muestra (porque ksmps=1)
  
  kAmp = abs(ain)           ; la amplitud es el valor absoluto de la muestra
                            
  if kAmp<=iUmbPCM then                 ; la condicion para calcular la ganancia
    kGm=1; si no debe actuar el compresor
  else
    kGm=(kAmp/iUmbPCM)^((1/iRatio)-1); si debe actuar el compresor
  endif
  
  aout = ain*kGm            ; aplicar la ganancia: y[n] = x[n] * g[n]
          out     aout      ; sacar la sennal de salida
endin

</CsInstruments>
<CsScore>

t 0 60 ; tempo 60 desde el inicio

;      p1      p2  p3       p4         p5     p6
;   instrum   ini dur    fichero     umbral ratio 
;---------------------------------------------------
i "compresor" 0.0 9.0 "percusion.wav"   0   [1/1] ; 1a vez no actua el compresor
i "compresor" 9.0 9.0 "percusion.wav"  -8   [1.3/1]
i "compresor" 18.0 9.0 "percusion.wav" -6   [18/1]

e

</CsScore>
</CsoundSynthesizer>
<bsbPanel>
 <label>Widgets</label>
 <objectName/>
 <x>17</x>
 <y>0</y>
 <width>0</width>
 <height>0</height>
 <visible>true</visible>
 <uuid>{a34025d3c6cfbfc143e7f4cc6c24f135}</uuid>
 <bgcolor mode="nobackground">
  <r>255</r>
  <g>255</g>
  <b>255</b>
 </bgcolor>
</bsbPanel>
<bsbPresets>
</bsbPresets>
