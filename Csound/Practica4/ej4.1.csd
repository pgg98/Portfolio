<CsoundSynthesizer>
<CsOptions>
-W -o "ej4.1.wav"
</CsOptions>
<CsInstruments>

instr LEER
	ain soundin "in.wav"
			out 		ain
endin
</CsInstruments>
<CsScore>
t 0 60

i "LEER"	0	3

e
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
