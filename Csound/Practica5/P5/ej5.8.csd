<CsoundSynthesizer>
<CsOptions>
-W -o ej5.8.wav
</CsOptions>
<CsInstruments>

; inicializaciones de los parametros globales

sr = 44100  ; frecuencia de muestreo
ksmps  = 1  ; muestras calculadas en cada ciclo de control
nchnls = 1  ; sonido monoaural

; INSTRUMENTO PARA CREAR TONOS DTMF

instr dtfm
  iA1  = ampdbfs(p4)  ; se recibe en dBFS y se convierte a PCM
  iA2  = iA1+2
  prints "Amplitud del tono alto: %d\n", round(iA2)
  iF1  = p5             ; se recibe ya en Hz
  iF2  = p6             
  ipi  = $M_PI        ; contiene el valor de pi
  
  kn timek
  
  a1=iA1*sin(2*ipi*iF1*kn/sr)
  a2=iA2*sin(2*ipi*iF2*kn/sr);
	a3=a1+a2
	out a3

endin

</CsInstruments>
<CsScore>

t 0 200 ; tempo constante desde el principio = 200 BPM --> 1 tiempo = 0,3 s

;   ins  ini  dur  amp   fbaja falta
;                 (dBFS)  (Hz)  (Hz)
;    p1   p2   p3   p4     p5    p6
;-------------------------------------
i "dtfm"  0   0.5  -10   852		1209  
i    .    1    .    . 	 770   1209
i    .    2    .    .    770   1336
i    .    3    .    .    697   1477
i    .     4    .   .   770   1336
i    .     5    .   .   852   1477
i    .     6    .   .   770   1477
i    .     7    .   .   697   1477
i    .     8    .   .   697   1209


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
