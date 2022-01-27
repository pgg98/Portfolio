<CsoundSynthesizer>
<CsOptions>
-W -o ej6.7.wav  ; Fichero de salida si Render
</CsOptions>
<CsInstruments>

; Se inicializan las variables globales.
sr  = 44100
ksmps = 1
0dbfs = 1

; Instrumento PEINE FIR

instr peineFIR
  SFich  = p4
  iDelta = 1/sr    ;  idelta = T_s
  ia0    = 1/2        ;  coef para x[n]
  iaD    = p5        ;  coef para x[n-D]
  itD    = p6/1000        ;  delay time (pasar el valor que llega a segundos)
  ia1 = 1/2

  if iaD == -1 then
  		ia1 = -1/2
  endif
  
  
  
  ain soundin SFich
  
  ain1 delay ain, itD
  
  aout=(1/2)*ain1*ia0+(1/2)*ain1*ia1
  
  out aout

endin

</CsInstruments>
<CsScore>

t 0 60

;     p1      p2  p3     p4        p5     p6
;    ins     ini dur  fichero   signo  tD(ms)
;---------------------------------------------
i "peineFIR" 0 1 "f_var.wav" +1 0.3
i "peineFIR" 1.5 1 "f_var.wav" -1 0.3
i "peineFIR" 3 4 "perc.wav" +1 1.3

e

</CsScore>
</CsoundSynthesizer>
<bsbPanel>
 <label>Widgets</label>
 <objectName/>
 <x>0</x>
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
