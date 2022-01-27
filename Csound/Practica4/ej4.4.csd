<CsoundSynthesizer>
<CsOptions>
-odac
</CsOptions>
<CsInstruments>

sr = 44100
ksmps = 10
nchnls = 1
0dbfs = 2^15

instr BEEP
	iamp = ampdbfs(p4)
	ifrec = cpspch(p5)
	
	print p4, iamp
	print p5, ifrec
	
	asal oscils iamp , ifrec , 0
			out		asal
endin
</CsInstruments>
<CsScore>
t 0 90

i "BEEP"	0	1	-5		8.04
i "BEEP"	0	1	0.75	-6
i "BEEP"	0	1	-4		1
i "BEEP"	0	1	-8		0
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
