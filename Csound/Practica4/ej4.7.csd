<CsoundSynthesizer>
<CsOptions>
-W -o ej4.7.wav
</CsOptions>
<CsInstruments>
nchnls = 1
sr = 44100
0dbfs = 2^15

instr Nota
	iAmp  = ampdbfs(p4) 
	iFrec = cpspch(p5) 

	aSal  oscils  iAmp , iFrec , 0
      	out     aSal 
endin

</CsInstruments>
<CsScore>
t  0  120

i "Nota"  0   0.5  -20   523
i "Nota"  +    .    <    587
i "Nota"  +    .    <    659
i "Nota"  +    .    <    698
i "Nota"  +    .    <    783
i "Nota"  +    .    <    880
i "Nota"  +    .    <    987
i "Nota"  +    .    -3   1046


i "Nota"  +   0.5  -12  200
i "Nota"  +   0.5   0   0

i "Nota"  5   1.0  -12  200
i "Nota"  5    .   -12  200
i "Nota"  5    .   -12  200

i "Nota"  6   2.0  0  0
</CsScore>
</CsoundSynthesizer>
<bsbPanel>
 <label>Widgets</label>
 <objectName/>
 <x>100</x>
 <y>100</y>
 <width>320</width>
 <height>240</height>
 <visible>true</visible>
 <uuid/>
 <bgcolor mode="nobackground">
  <r>255</r>
  <g>255</g>
  <b>255</b>
 </bgcolor>
</bsbPanel>
<bsbPresets>
</bsbPresets>
