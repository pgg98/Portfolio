<CsoundSynthesizer>
<CsOptions>
-W -o ej9.2.wav
</CsOptions>
<CsInstruments>

sr = 44100
ksmps = 128
nchnls = 2
0dbfs = 32768

instr treal
  kNota invalue "NOTA" ; <-- aqui lectura del widget de la nota
  kAdBFS invalue "AMPLIDBFS" ; <-- aqui lectura del widget de la amplitud dBFS
  kOn invalue "ACTIVAR"
  kPan invalue "PANORAMA"
  kNota  = 40   ; Descomentar solo para entrega
  kAdBFS = -6   ; Descomentar solo para entrega
  kOn = 1
  kFrec = 27.5*2^((kNota-1)/12) ; pasar de numero de nota a frecuencia en Hz
  kAPCM = ampdbfs(kAdBFS) ; pasar de dBFS al rango PCM
  kAPCM = kAPCM*kOn
  kMenu invalue "FORMA"

	outvalue "FRECUENCIA", kFrec
	outvalue "AMPLIPCM", round(kAPCM)

	if kMenu==0 then
		aSal vco2    kAPCM, kFrec, 12
		
		aIzq=aSal*(1-kPan)
 		aDer=aSal*kPan
		
    	outs    aIzq, aDer
    	dispfft aSal, 1, 2048
 	else
 		aSal vco2    kAPCM, kFrec, 10
 		
 		aIzq=aSal*(1-kPan)
 		aDer=aSal*kPan
 		
    	outs    aIzq, aDer
    	dispfft aSal, 1, 2048
  endif
endin

</CsInstruments>
<CsScore>
t 0 5000 ; Descomentar solo para entrega
i "treal" 0 60
e
</CsScore>
</CsoundSynthesizer>
<bsbPanel>
 <label>Widgets</label>
 <objectName/>
 <x>608</x>
 <y>211</y>
 <width>408</width>
 <height>357</height>
 <visible>true</visible>
 <uuid>{a34025d3c6cfbfc143e7f4cc6c24f135}</uuid>
 <bgcolor mode="background">
  <r>226</r>
  <g>213</g>
  <b>204</b>
 </bgcolor>
 <bsbObject type="BSBLabel" version="2">
  <objectName/>
  <x>5</x>
  <y>4</y>
  <width>539</width>
  <height>41</height>
  <uuid>{c5f4063e-4a46-4f9d-96db-839bea9a983f}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <label>Generador de ondas geometricas</label>
  <alignment>center</alignment>
  <valignment>top</valignment>
  <font>Arial</font>
  <fontsize>24</fontsize>
  <precision>3</precision>
  <color>
   <r>0</r>
   <g>0</g>
   <b>0</b>
  </color>
  <bgcolor mode="background">
   <r>230</r>
   <g>202</g>
   <b>141</b>
  </bgcolor>
  <bordermode>border</bordermode>
  <borderradius>1</borderradius>
  <borderwidth>1</borderwidth>
 </bsbObject>
 <bsbObject type="BSBLabel" version="2">
  <objectName/>
  <x>10</x>
  <y>54</y>
  <width>262</width>
  <height>55</height>
  <uuid>{7650f5b0-e83a-46a4-ba7f-45a47f71997e}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <label>Spin Box para controlar el n√∫mero de tecla del piano seleccionada (de la 1 a la 88)
(por el canal NOTA)</label>
  <alignment>center</alignment>
  <valignment>top</valignment>
  <font>Arial</font>
  <fontsize>12</fontsize>
  <precision>3</precision>
  <color>
   <r>0</r>
   <g>0</g>
   <b>0</b>
  </color>
  <bgcolor mode="background">
   <r>216</r>
   <g>203</g>
   <b>234</b>
  </bgcolor>
  <bordermode>border</bordermode>
  <borderradius>5</borderradius>
  <borderwidth>1</borderwidth>
 </bsbObject>
 <bsbObject type="BSBLabel" version="2">
  <objectName/>
  <x>9</x>
  <y>116</y>
  <width>263</width>
  <height>41</height>
  <uuid>{baae2608-4500-4d99-99f3-941f5e2b5a84}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <label>Slider horizontal para controlar la amplitud en dBFS entre -60 y 0 (por el canal AMPLIDBFS)</label>
  <alignment>center</alignment>
  <valignment>top</valignment>
  <font>Arial</font>
  <fontsize>12</fontsize>
  <precision>3</precision>
  <color>
   <r>0</r>
   <g>0</g>
   <b>0</b>
  </color>
  <bgcolor mode="background">
   <r>235</r>
   <g>236</g>
   <b>171</b>
  </bgcolor>
  <bordermode>border</bordermode>
  <borderradius>1</borderradius>
  <borderwidth>1</borderwidth>
 </bsbObject>
 <bsbObject type="BSBScope" version="2">
  <objectName/>
  <x>9</x>
  <y>172</y>
  <width>420</width>
  <height>173</height>
  <uuid>{72fc1a74-2bf1-4f9e-a785-19c14a2a576a}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>-3</midicc>
  <description/>
  <value>-255.00000000</value>
  <type>scope</type>
  <zoomx>2.00000000</zoomx>
  <zoomy>1.00000000</zoomy>
  <dispx>1.00000000</dispx>
  <dispy>1.00000000</dispy>
  <mode>0.00000000</mode>
 </bsbObject>
 <bsbObject type="BSBDisplay" version="2">
  <objectName>AMPLIDBFS</objectName>
  <x>277</x>
  <y>134</y>
  <width>46</width>
  <height>25</height>
  <uuid>{18b74d02-e990-432f-a0cb-8ea3f08c6805}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>-3</midicc>
  <description/>
  <label>-10.313</label>
  <alignment>left</alignment>
  <valignment>top</valignment>
  <font>Arial</font>
  <fontsize>10</fontsize>
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
  <bordermode>false</bordermode>
  <borderradius>1</borderradius>
  <borderwidth>0</borderwidth>
 </bsbObject>
 <bsbObject type="BSBLabel" version="2">
  <objectName/>
  <x>317</x>
  <y>135</y>
  <width>36</width>
  <height>22</height>
  <uuid>{28662cb8-2d8f-4182-aced-cd3626320505}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>-3</midicc>
  <description/>
  <label>dBFS</label>
  <alignment>left</alignment>
  <valignment>top</valignment>
  <font>Arial</font>
  <fontsize>10</fontsize>
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
 <bsbObject type="BSBSpinBox" version="2">
  <objectName>NOTA</objectName>
  <x>285</x>
  <y>54</y>
  <width>80</width>
  <height>25</height>
  <uuid>{bca0fde4-2b94-4c12-9e2c-f2bae2686b62}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <alignment>right</alignment>
  <font>Arial</font>
  <fontsize>14</fontsize>
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
  <resolution>1.00000000</resolution>
  <minimum>1</minimum>
  <maximum>88</maximum>
  <randomizable group="0">false</randomizable>
  <value>47</value>
 </bsbObject>
 <bsbObject type="BSBLabel" version="2">
  <objectName/>
  <x>397</x>
  <y>54</y>
  <width>46</width>
  <height>26</height>
  <uuid>{8ff0af87-79d3-49de-a553-31792d7e9f60}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>-3</midicc>
  <description/>
  <label>FREC:</label>
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
  <bordermode>false</bordermode>
  <borderradius>1</borderradius>
  <borderwidth>0</borderwidth>
 </bsbObject>
 <bsbObject type="BSBLabel" version="2">
  <objectName/>
  <x>511</x>
  <y>53</y>
  <width>28</width>
  <height>27</height>
  <uuid>{31f0c7e4-8635-4463-a189-6d92fc966d0c}</uuid>
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
  <bordermode>false</bordermode>
  <borderradius>1</borderradius>
  <borderwidth>0</borderwidth>
 </bsbObject>
 <bsbObject type="BSBDisplay" version="2">
  <objectName>FRECUENCIA</objectName>
  <x>448</x>
  <y>54</y>
  <width>57</width>
  <height>25</height>
  <uuid>{e78b2aee-4eeb-4c15-8beb-69576825cc01}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>-3</midicc>
  <description/>
  <label>391.995</label>
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
  <bordermode>true</bordermode>
  <borderradius>1</borderradius>
  <borderwidth>1</borderwidth>
 </bsbObject>
 <bsbObject type="BSBHSlider" version="2">
  <objectName>AMPLIDBFS</objectName>
  <x>286</x>
  <y>92</y>
  <width>256</width>
  <height>26</height>
  <uuid>{afc223f3-7682-4385-9681-94927720895f}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <minimum>-60.00000000</minimum>
  <maximum>0.00000000</maximum>
  <value>-10.31250000</value>
  <mode>lin</mode>
  <mouseControl act="jump">continuous</mouseControl>
  <resolution>-1.00000000</resolution>
  <randomizable group="0">false</randomizable>
 </bsbObject>
 <bsbObject type="BSBDisplay" version="2">
  <objectName>AMPLIPCM</objectName>
  <x>453</x>
  <y>133</y>
  <width>74</width>
  <height>28</height>
  <uuid>{0f572b47-415b-4b2b-b9fe-61d281904d9c}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>-3</midicc>
  <description/>
  <label>9996.000</label>
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
  <bordermode>true</bordermode>
  <borderradius>1</borderradius>
  <borderwidth>1</borderwidth>
 </bsbObject>
 <bsbObject type="BSBLabel" version="2">
  <objectName/>
  <x>408</x>
  <y>133</y>
  <width>43</width>
  <height>27</height>
  <uuid>{85abf825-f44e-4d97-96d6-5a76e377a34a}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>-3</midicc>
  <description/>
  <label>AMP:</label>
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
  <bordermode>false</bordermode>
  <borderradius>1</borderradius>
  <borderwidth>0</borderwidth>
 </bsbObject>
 <bsbObject type="BSBLabel" version="2">
  <objectName/>
  <x>531</x>
  <y>134</y>
  <width>41</width>
  <height>25</height>
  <uuid>{ca9bd052-f651-4f64-8a4f-0b02b1924503}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>-3</midicc>
  <description/>
  <label>PCM</label>
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
  <bordermode>false</bordermode>
  <borderradius>1</borderradius>
  <borderwidth>0</borderwidth>
 </bsbObject>
 <bsbObject type="BSBCheckBox" version="2">
  <objectName>ACTIVAR</objectName>
  <x>451</x>
  <y>197</y>
  <width>20</width>
  <height>20</height>
  <uuid>{52eca781-b8aa-410b-930a-597b3de55aa1}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>-3</midicc>
  <description/>
  <selected>true</selected>
  <label/>
  <pressedValue>1</pressedValue>
  <randomizable group="0">false</randomizable>
 </bsbObject>
 <bsbObject type="BSBLabel" version="2">
  <objectName/>
  <x>478</x>
  <y>195</y>
  <width>34</width>
  <height>25</height>
  <uuid>{e0536c5f-1460-49de-bba2-8a87494e60c3}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>-3</midicc>
  <description/>
  <label>ON</label>
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
  <bordermode>false</bordermode>
  <borderradius>1</borderradius>
  <borderwidth>0</borderwidth>
 </bsbObject>
 <bsbObject type="BSBDropdown" version="2">
  <objectName>FORMA</objectName>
  <x>446</x>
  <y>256</y>
  <width>100</width>
  <height>30</height>
  <uuid>{57bdf96e-f477-4c6b-8ded-10ca2264fed8}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>-3</midicc>
  <description/>
  <bsbDropdownItemList>
   <bsbDropdownItem>
    <name>Triangular</name>
    <value>0</value>
    <stringvalue/>
   </bsbDropdownItem>
   <bsbDropdownItem>
    <name>Cuadrada</name>
    <value>1</value>
    <stringvalue/>
   </bsbDropdownItem>
  </bsbDropdownItemList>
  <selectedIndex>1</selectedIndex>
  <randomizable group="0">false</randomizable>
 </bsbObject>
 <bsbObject type="BSBKnob" version="2">
  <objectName>PANORAMA</objectName>
  <x>469</x>
  <y>410</y>
  <width>80</width>
  <height>80</height>
  <uuid>{1bafc8a4-fb1c-4f71-b8c2-7d3b5aa5ad0a}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <minimum>0.00000000</minimum>
  <maximum>1.00000000</maximum>
  <value>0.50000000</value>
  <mode>lin</mode>
  <mouseControl act="">continuous</mouseControl>
  <resolution>0.01000000</resolution>
  <randomizable group="0">false</randomizable>
  <color>
   <r>245</r>
   <g>124</g>
   <b>0</b>
  </color>
  <textcolor>#512900</textcolor>
  <border>0</border>
  <borderColor>#512900</borderColor>
  <showvalue>true</showvalue>
  <flatstyle>true</flatstyle>
  <integerMode>false</integerMode>
 </bsbObject>
 <bsbObject type="BSBLabel" version="2">
  <objectName/>
  <x>468</x>
  <y>378</y>
  <width>80</width>
  <height>25</height>
  <uuid>{21757713-a5c4-4950-ba0f-012fd55b4290}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>-3</midicc>
  <description/>
  <label>panor·mico</label>
  <alignment>center</alignment>
  <valignment>top</valignment>
  <font>Arial</font>
  <fontsize>12</fontsize>
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
  <bordermode>false</bordermode>
  <borderradius>1</borderradius>
  <borderwidth>0</borderwidth>
 </bsbObject>
 <bsbObject type="BSBController" version="2">
  <objectName>PANORAMA</objectName>
  <x>466</x>
  <y>499</y>
  <width>88</width>
  <height>31</height>
  <uuid>{2fae157b-d2dd-4410-91e4-086a9beeaab4}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <objectName2/>
  <xMin>0.00000000</xMin>
  <xMax>1.00000000</xMax>
  <yMin>0.00000000</yMin>
  <yMax>1.00000000</yMax>
  <xValue>0.50000000</xValue>
  <yValue>0.00000000</yValue>
  <type>line</type>
  <pointsize>1</pointsize>
  <fadeSpeed>0.00000000</fadeSpeed>
  <mouseControl act="press">jump</mouseControl>
  <bordermode>noborder</bordermode>
  <borderColor>#00ff00</borderColor>
  <color>
   <r>0</r>
   <g>234</g>
   <b>0</b>
  </color>
  <randomizable group="0" mode="both">false</randomizable>
  <bgcolor>
   <r>30</r>
   <g>30</g>
   <b>30</b>
  </bgcolor>
  <bgcolormode>true</bgcolormode>
 </bsbObject>
 <bsbObject type="BSBGraph" version="2">
  <objectName/>
  <x>9</x>
  <y>361</y>
  <width>421</width>
  <height>190</height>
  <uuid>{130bad79-bab7-4590-8cde-57da40d3193a}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>-3</midicc>
  <description/>
  <value>0</value>
  <objectName2/>
  <zoomx>1.00000000</zoomx>
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
<preset name="PRUEBA" number="0" >
<value id="{dfc109a0-ff5a-40e4-9a56-bb67e10acb6a}" mode="1" >500.76678467</value>
<value id="{9d18e25d-d310-4e60-9109-541fdad0d7df}" mode="1" >-255.00000000</value>
<value id="{3fb71cce-6862-4460-85a0-da5196b0daa5}" mode="1" >0.51999998</value>
<value id="{36d598cd-b19e-4745-95d8-fa168011fb75}" mode="1" >500.76678467</value>
<value id="{36d598cd-b19e-4745-95d8-fa168011fb75}" mode="4" >500.767</value>
</preset>
<preset name="PRUEBA" number="1" >
<value id="{dfc109a0-ff5a-40e4-9a56-bb67e10acb6a}" mode="1" >228.75399780</value>
<value id="{9d18e25d-d310-4e60-9109-541fdad0d7df}" mode="1" >-255.00000000</value>
<value id="{3fb71cce-6862-4460-85a0-da5196b0daa5}" mode="1" >0.49999997</value>
<value id="{36d598cd-b19e-4745-95d8-fa168011fb75}" mode="1" >228.75399780</value>
<value id="{36d598cd-b19e-4745-95d8-fa168011fb75}" mode="4" >228.754</value>
</preset>
</bsbPresets>
