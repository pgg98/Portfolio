<CsoundSynthesizer>
<CsOptions>
-W -o ej6.5.wav  ; fichero de salida, si Render
</CsOptions>
<CsInstruments>

; Parametros de cabecera:
sr = 44100 ; frecuencia de muestreo
0dbfs =  1 ; maxima amplitud del rango

opcode medicion, 0,ai
as,iF xin
  kApico init   0
  kMetro metro  200
  kApico max_k  as, kMetro, 1
  kTime  times
  if round(sr*kTime/2)==iF then
    prints   " F = %d Hz\n",iF
    printks2 " t = %5.3f s\n", kTime
    printks2 " G = %5.1f dBFS\n", dbfsamp(kApico)
  endif
endop

; Instrumento FPBnd FIR orden 2 con delay 2D

instr febnFIR
  SFich  = p4
  iTs    = 1/sr   ; T_s (1 periodo de muestreo = 1/frecuencia de muestreo)
  ia0    = 1/5       ; coef para x[n]
  ia2    =  1/5      ; coef para x[n-2]/

  ; leer el sonido
  ; crear senal retardada
  ; aplicar la ecuación del filtro para calcular la salida
  ; y sacar el sonido
endin

</CsInstruments>
<CsScore>

t 0 60

;     p1    p2  p3     p4   
;    ins   ini dur  fichero
;------------------------------
i "febnFIR" 0   1  "f_var.wav"

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
