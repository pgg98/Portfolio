<CsoundSynthesizer>
<CsOptions>
-W -o ej6.3.wav
</CsOptions>
<CsInstruments>

; Parametros de cabecera:
sr = 44100 ; frecuencia de muestreo
ksmps = 10 ; muestras por ciclo
0dbfs =  1 ; maxima amplitud del rango

; Instrumento FPB FIR de orden 4

instr pasaaltaFIR
  SFich  = p4      ;  fichero con la onda a filtrar
  ia0    = 1/5     ;  coef. para x[n]. Todos los coeficientes deben ser iguales
  ia1    = -1/5     ;  coef. para x[n-1]
  ia2    = 1/5     ;  coef. para x[n-2]
  ia3    = -1/5     ;  coef. para x[n-3]
  ia4    = 1/5     ;  coef. para x[n-4]

  ain    soundin  SFich   ; FICHERO ENVIADO DESDE LA PARTITURA

; AQUI LOS DELAYS (se pone el primero para que veas como funciona)
  ain_1  delay1   ain
  ain_2	 delay1 ain_1
  ain_3 delay1 ain_2
  ain_4 delay1 ain_3
  
; Luego HAY QUE APLICAR LA ECUACION PARA CREAR LA SALIDA FILTRADA
aout=ia0*ain+ia1*ain_1+ia2*ain_2+ia3*ain_3+ia4*ain_4

         out      aout
endin


</CsInstruments>
<CsScore>

t 0 60   ; tempo 60 BPM (1 tiempo = 1 segundo) 

;    p1     p2  p3     p4
;   ins    ini dur   fichero
;------------------------------
i "pasaaltaFIR"  0   1  "f_2800.wav"

e

</CsScore>
</CsoundSynthesizer>
<bsbPanel>
 <label>Widgets</label>
 <objectName/>
 <x>16</x>
 <y>17</y>
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
