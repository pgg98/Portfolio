<CsoundSynthesizer>
<CsOptions>
-W -o ej5.14.wav
</CsOptions>
<CsInstruments>

sr=32000
kr=64
nchnls = 1

instr RUIDOS
	idur=p3
	iamp=p4
	itiempo times

	if itiempo<idur/3 then
	
	aOut oscil iamp, 32000
	elseif itiempo<2*idur/3 then
	awhite unirand 2.0
	awhite=awhite-1.0
	aOut pinkish awhite, 1,0,0,1
	else
	kbeta line -0.9999, p3, 0.9999	;change beta value between -1 to 1
	aOut  noise .3, kbeta
	endif

  dispfft aOut, 0.1, 2048
  
  print dbfsamp(iamp)
endin

</CsInstruments>
<CsScore>

i "RUIDOS" 0 4 4 0.7

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
 <bsbObject version="2" type="BSBScope">
  <objectName/>
  <x>5</x>
  <y>5</y>
  <width>400</width>
  <height>200</height>
  <uuid>{3a8491b3-9c49-4da6-acb7-e18421d64b92}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <value>-255.00000000</value>
  <type>scope</type>
  <zoomx>2.00000000</zoomx>
  <zoomy>1.00000000</zoomy>
  <dispx>1.00000000</dispx>
  <dispy>1.00000000</dispy>
  <mode>0.00000000</mode>
 </bsbObject>
 <bsbObject version="2" type="BSBGraph">
  <objectName/>
  <x>5</x>
  <y>210</y>
  <width>400</width>
  <height>200</height>
  <uuid>{0ccc2fbf-3914-4ae0-95a7-a24340a2da8b}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <value>0</value>
  <objectName2/>
  <zoomx>2.00000000</zoomx>
  <zoomy>1.00000000</zoomy>
  <dispx>1.00000000</dispx>
  <dispy>1.00000000</dispy>
  <modex>lin</modex>
  <modey>lin</modey>
  <showSelector>true</showSelector>
  <showGrid>true</showGrid>
  <showTableInfo>true</showTableInfo>
  <showScrollbars>true</showScrollbars>
  <enableTables>true</enableTables>
  <enableDisplays>true</enableDisplays>
  <all>true</all>
 </bsbObject>
</bsbPanel>
<bsbPresets>
</bsbPresets>
