<CsoundSynthesizer>
<CsOptions>
-W -o ej6.4.wav  ; fichero de salida, si Render
</CsOptions>
<CsInstruments>

; Variables globales:
sr = 44100 ; frecuencia de muestreo
ksmps =  1 ; muestras por ciclo - debe ser 1 por la realimentacion
0dbfs =  1 ; maxima amplitud del rango

; Instrumento FPB IIR de orden 1

opcode crucefc, 0,a
as xin
  kMetro metro   250            ; para medir la envolvente 250 veces/s
  kEnv   max_k   as, kMetro, 1  ; mide la envolvente de pico
  kTrig  trigger kEnv, 0.707, 1 ; cuando su valor cruza por 0.707 hacia abajo
  if kTrig==1 then
    kTime timeinsts             ; mide el tiempo
    printks2 "Frecuencia de corte = %d Hz\n", kTime*sr/2
  endif
endop

instr fpbIIR
  SFich =    p4      ;  fichero con la onda a filtrar
  ia    =    p5      ;  coef. a (para y[n-1])
  aout  init  0      ;  crea e inicializa aout

  ain   soundin  SFich

; solo falta implementar la ecuacion de onda de este filtro
; recuerda: aout en la derecha es y[n-1] y en la izquierda es y[n]

aout=(1-ia)*ain+ia*aout

crucefc  aout

        out      aout
endin

</CsInstruments>
<CsScore>

t 0 60   ; tempo 60 BPM (1 tiempo = 1 segundo) 

;     p1    p2  p3     p4       p5
;    ins   ini dur   fichero  coef.a 
;------------------------------------
i "fpbIIR"  0   1  "f_var.wav"  0.75 
i "fpbIIR"  1   1  "f_var.wav"  0.92
i "fpbIIR"  2   1  "f_var.wav"  0.90

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
