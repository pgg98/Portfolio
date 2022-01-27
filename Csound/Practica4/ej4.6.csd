<CsoundSynthesizer>
<CsOptions>
-W -o ej4.6.wav
</CsOptions>
<CsInstruments>

nchnls = 1
sr = 44100
0dbfs = 2^15

instr Nota
	iAmp  = p4 
	iFrec = p5 

	aSal  oscils  iAmp , iFrec , 0
      	out     aSal 
endin
</CsInstruments>
<CsScore>
t  0  100

i "Nota"  0   1.0  10000  200
i "Nota"  1   2.0  20000  800
i "Nota"  3   1.5  30000  400
i "Nota"  4.5  0.5  15000  440

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
