<CsoundSynthesizer>
<CsOptions>
-n
</CsOptions>
<CsInstruments>

instr format
 	SFich = p4
 	
 	ifs		filesr			SFich
 	iNChan	filenchnls 	SFich
 	iNBit	filebit			SFich
 	iDura 	filelen			SFich
 	
 		print ifs, iNChan, iNBit, iDura
 	
 	iBytes=
 	iFlujo=
 	iMuest=
 	
 		print iBytes, iFlujo, iMuest
 		prints	"\n"
endin


</CsInstruments>
<CsScore>
i "format" 0 0.1 "5.1.08.wav"
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
