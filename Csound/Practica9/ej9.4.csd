<CsoundSynthesizer>
<CsOptions>
-W -o ej9.4.wav
</CsOptions>
<CsInstruments>

sr = 44100
ksmps = 128
0dbfs = 32768

seed 6  ; para la curva aleatoria

instr viento
 	iAmp=0dbfs/2
 	
 	ares pinkish iAmp
 	
 	iFrec=randomi 50, 2500, 1 
 	
 	aSal K35_lpf ares, iFrec,  9.5 
 	
	outvalue "FCORTE", iFrec

  out     aSal
  dispfft aSal, 0.1, 1024, 1, 0
endin


</CsInstruments>
<CsScore>

i "viento" 0 15 

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
 <bsbObject type="BSBController" version="2">
  <objectName/>
  <x>6</x>
  <y>8</y>
  <width>20</width>
  <height>194</height>
  <uuid>{d84a9d76-5573-4b70-b132-6d8fe5f79ce4}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <objectName2>FCORTE</objectName2>
  <xMin>0.00000000</xMin>
  <xMax>1.00000000</xMax>
  <yMin>30.00000000</yMin>
  <yMax>2500.00000000</yMax>
  <xValue>0.00000000</xValue>
  <yValue>91.27910510</yValue>
  <type>fill</type>
  <pointsize>1</pointsize>
  <fadeSpeed>0.00000000</fadeSpeed>
  <mouseControl act="press">jump</mouseControl>
  <bordermode>noborder</bordermode>
  <borderColor>#00FF00</borderColor>
  <color>
   <r>0</r>
   <g>234</g>
   <b>0</b>
  </color>
  <randomizable group="0" mode="both">false</randomizable>
  <bgcolor>
   <r>0</r>
   <g>0</g>
   <b>0</b>
  </bgcolor>
  <bgcolormode>true</bgcolormode>
 </bsbObject>
 <bsbObject type="BSBGraph" version="2">
  <objectName/>
  <x>28</x>
  <y>8</y>
  <width>462</width>
  <height>192</height>
  <uuid>{a422e564-1ec5-45a4-866c-406d9d3fbfdf}</uuid>
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
 <bsbObject type="BSBDisplay" version="2">
  <objectName>FCORTE</objectName>
  <x>4</x>
  <y>206</y>
  <width>64</width>
  <height>30</height>
  <uuid>{7ac4e436-059c-4a70-9775-7e306d5009f3}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>-3</midicc>
  <description/>
  <label>91.279</label>
  <alignment>left</alignment>
  <valignment>top</valignment>
  <font>Arial</font>
  <fontsize>14</fontsize>
  <precision>3</precision>
  <color>
   <r>0</r>
   <g>0</g>
   <b>0</b>
  </color>
  <bgcolor mode="background">
   <r>255</r>
   <g>255</g>
   <b>255</b>
  </bgcolor>
  <bordermode>border</bordermode>
  <borderradius>1</borderradius>
  <borderwidth>1</borderwidth>
 </bsbObject>
 <bsbObject type="BSBLabel" version="2">
  <objectName/>
  <x>72</x>
  <y>207</y>
  <width>31</width>
  <height>25</height>
  <uuid>{c4751764-1e14-4a90-a898-9345ada09b72}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>-3</midicc>
  <description/>
  <label>Hz</label>
  <alignment>left</alignment>
  <valignment>top</valignment>
  <font>Arial</font>
  <fontsize>14</fontsize>
  <precision>3</precision>
  <color>
   <r>0</r>
   <g>0</g>
   <b>0</b>
  </color>
  <bgcolor mode="nobackground">
   <r>255</r>
   <g>255</g>
   <b>255</b>
  </bgcolor>
  <bordermode>noborder</bordermode>
  <borderradius>1</borderradius>
  <borderwidth>0</borderwidth>
 </bsbObject>
</bsbPanel>
<bsbPresets>
</bsbPresets>
