<CsoundSynthesizer>
<CsOptions>
-W -o ej9.5.wav
</CsOptions>
<CsInstruments>

0dbfs = 1  ; amplitud maxima normalizada
ksmps = 1  ; maxima precision en el calculo de las variables k-

; Este instrumento lee los widgets y activa el instrumento nota

instr lee_parametros    ; NO SE DEBE MODIFICAR
  ktA   invalue "tata"  ; Lee el tiempo de ataque desde el widget
  ktD   invalue "tdec"  ; Lee el tiempo de caida
  kAS   invalue "asus"  ; Lee la amplitud de sostenimiento
  ktR   invalue "trel"  ; Lee el tiempo de relajación
  kTipo invalue "tipo"  ; Lee el tipo de envolvente
  iNota = cpsmidinn(p4) ; Recibe la nota midi 60 (DO4) que pasa a Hz
           ;  p1   p2 p3   p4    p5   p6  p7  p8  p9
  event "i","nota", 0, 2,iNota,kTipo,ktA,ktD,kAS,ktR
  turnoff
endin

; instrumento para crear y aplicar la envolvente

instr nota
  iDur  = p3       ; Duracion de la nota en segundos
  iFrec = p4       ; Frecuencia
  iTipo = p5       ; Tipo de envolvente: 0=ASR/AR, 1=ADSR, 2=ADSR-X
  itAta = p6         ; tA absoluto en segundos
  itDec = p7*iDur         ; tD relativo a la duracion
  iAsus = p8         ; AS entre 0 y 1
  itRel = p9*iDur         ; tR relativo a duracion


  ; para verificar los valores en la consola:
  prints "\nTIEMPOS DE LA ENVOLVENTE:\ntA =%5.2f, tD =%5.2f, As =%5.2f, tR =%5.2f\n", itAta, itDec, iAsus, itRel

	if iTipo=0 then 
  ;Crear envolvente AR/ASR con linen
  	kres linen 1, itAta, iDur, itRel
	elseif iTipo=1 then
  ;Crear envolvente ADSR con adsr
  kres adsr itAta, itDec, iAsus, itRel
	elseif iTipo=2 then
  ;Crear envolvente ADSR-X con madsr
  kres madsr itAta, itDec, iAsus, itRel 
	endif
	
	aSal vco2 0dbfs/2, iFrec, 12
	
	aSal= aSal*kres  
	
	out aSal

  outvalue  "ENVOLVENTE", kres
endin

</CsInstruments>
<CsScore>

f 0 [2*60] ; mantiene activo el programa durante 2 minutos
;i "lee_parametros" 0 0.1 60

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
 <uuid>{a34025d3c6cfbfc143e7f4cc6c24f135}</uuid>
 <bgcolor mode="nobackground">
  <r>246</r>
  <g>255</g>
  <b>237</b>
 </bgcolor>
 <bsbObject type="BSBLabel" version="2">
  <objectName/>
  <x>17</x>
  <y>7</y>
  <width>163</width>
  <height>250</height>
  <uuid>{9e3d556f-e489-435d-bc7c-97a868c27d64}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <label>Envolvente de amplitud</label>
  <alignment>center</alignment>
  <valignment>top</valignment>
  <font>Lucida Grande</font>
  <fontsize>12</fontsize>
  <precision>3</precision>
  <color>
   <r>0</r>
   <g>0</g>
   <b>0</b>
  </color>
  <bgcolor mode="background">
   <r>181</r>
   <g>233</g>
   <b>238</b>
  </bgcolor>
  <bordermode>border</bordermode>
  <borderradius>1</borderradius>
  <borderwidth>1</borderwidth>
 </bsbObject>
 <bsbObject type="BSBVSlider" version="2">
  <objectName>tata</objectName>
  <x>39</x>
  <y>30</y>
  <width>20</width>
  <height>170</height>
  <uuid>{9c20c1f0-dac8-49c8-a022-14477e73432e}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <minimum>0.01000000</minimum>
  <maximum>1.95000000</maximum>
  <value>0.40941176</value>
  <mode>lin</mode>
  <mouseControl act="jump">continuous</mouseControl>
  <resolution>-1.00000000</resolution>
  <randomizable group="0">false</randomizable>
 </bsbObject>
 <bsbObject type="BSBVSlider" version="2">
  <objectName>tdec</objectName>
  <x>72</x>
  <y>30</y>
  <width>20</width>
  <height>170</height>
  <uuid>{3e1a333a-8f89-4086-bfb2-0db2e61e1a89}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <minimum>0.01000000</minimum>
  <maximum>0.30000000</maximum>
  <value>0.01000000</value>
  <mode>lin</mode>
  <mouseControl act="jump">continuous</mouseControl>
  <resolution>-1.00000000</resolution>
  <randomizable group="0">false</randomizable>
 </bsbObject>
 <bsbObject type="BSBVSlider" version="2">
  <objectName>asus</objectName>
  <x>105</x>
  <y>30</y>
  <width>20</width>
  <height>170</height>
  <uuid>{02d697b0-77e4-4d0c-add5-30e36794ece0}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <minimum>0.05000000</minimum>
  <maximum>1.00000000</maximum>
  <value>1.00000000</value>
  <mode>lin</mode>
  <mouseControl act="jump">continuous</mouseControl>
  <resolution>-1.00000000</resolution>
  <randomizable group="0">false</randomizable>
 </bsbObject>
 <bsbObject type="BSBVSlider" version="2">
  <objectName>trel</objectName>
  <x>139</x>
  <y>30</y>
  <width>20</width>
  <height>170</height>
  <uuid>{2e9cf2ae-7997-4391-9363-0ea7ba3fe217}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <minimum>0.01000000</minimum>
  <maximum>0.95000000</maximum>
  <value>0.20352941</value>
  <mode>lin</mode>
  <mouseControl act="jump">continuous</mouseControl>
  <resolution>-1.00000000</resolution>
  <randomizable group="0">false</randomizable>
 </bsbObject>
 <bsbObject type="BSBLabel" version="2">
  <objectName/>
  <x>39</x>
  <y>203</y>
  <width>18</width>
  <height>24</height>
  <uuid>{ed8bc21e-980d-438e-a004-8797008451b4}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>-3</midicc>
  <description/>
  <label>A</label>
  <alignment>left</alignment>
  <valignment>top</valignment>
  <font>DejaVu Sans</font>
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
 <bsbObject type="BSBLabel" version="2">
  <objectName/>
  <x>73</x>
  <y>203</y>
  <width>18</width>
  <height>24</height>
  <uuid>{9db192c7-a3b1-452d-ab86-7bc39b5a097e}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>-3</midicc>
  <description/>
  <label>D</label>
  <alignment>left</alignment>
  <valignment>top</valignment>
  <font>DejaVu Sans</font>
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
 <bsbObject type="BSBLabel" version="2">
  <objectName/>
  <x>107</x>
  <y>203</y>
  <width>18</width>
  <height>24</height>
  <uuid>{6e841111-90a7-44e2-94df-541c3d28aed5}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>-3</midicc>
  <description/>
  <label>S</label>
  <alignment>left</alignment>
  <valignment>top</valignment>
  <font>DejaVu Sans</font>
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
 <bsbObject type="BSBLabel" version="2">
  <objectName/>
  <x>141</x>
  <y>203</y>
  <width>18</width>
  <height>24</height>
  <uuid>{90de043d-9e1a-484e-86c1-2cf0d364f1d8}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>-3</midicc>
  <description/>
  <label>R</label>
  <alignment>left</alignment>
  <valignment>top</valignment>
  <font>DejaVu Sans</font>
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
 <bsbObject type="BSBButton" version="2">
  <objectName>nota</objectName>
  <x>215</x>
  <y>143</y>
  <width>83</width>
  <height>46</height>
  <uuid>{e4326a6a-c4fc-4223-9c46-355a3e2f2ff9}</uuid>
  <visible>true</visible>
  <midichan>1</midichan>
  <midicc>0</midicc>
  <description/>
  <type>event</type>
  <pressedValue>1.00000000</pressedValue>
  <stringvalue/>
  <text>NOTA</text>
  <image>/</image>
  <eventLine>i "lee_parametros" 0 0.1 60</eventLine>
  <latch>false</latch>
  <latched>false</latched>
  <fontsize>10</fontsize>
 </bsbObject>
 <bsbObject type="BSBController" version="2">
  <objectName/>
  <x>190</x>
  <y>6</y>
  <width>13</width>
  <height>251</height>
  <uuid>{28e0359f-76e6-4602-a0fa-33d68a1ebf55}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <objectName2>ENVOLVENTE</objectName2>
  <xMin>0.00000000</xMin>
  <xMax>1.00000000</xMax>
  <yMin>0.00000000</yMin>
  <yMax>1.00000000</yMax>
  <xValue>0.00000000</xValue>
  <yValue>0.00004424</yValue>
  <type>fill</type>
  <pointsize>1</pointsize>
  <fadeSpeed>0.00000000</fadeSpeed>
  <mouseControl act="press">jump</mouseControl>
  <bordermode>noborder</bordermode>
  <borderColor>#00FF00</borderColor>
  <color>
   <r>255</r>
   <g>250</g>
   <b>11</b>
  </color>
  <randomizable group="0" mode="both">false</randomizable>
  <bgcolor>
   <r>0</r>
   <g>0</g>
   <b>0</b>
  </bgcolor>
  <bgcolormode>true</bgcolormode>
 </bsbObject>
 <bsbObject type="BSBDisplay" version="2">
  <objectName>tata</objectName>
  <x>26</x>
  <y>224</y>
  <width>42</width>
  <height>26</height>
  <uuid>{6adcc342-95d1-4851-a0e9-b35a926f3c2a}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <label>0.409</label>
  <alignment>left</alignment>
  <valignment>top</valignment>
  <font>Arial</font>
  <fontsize>12</fontsize>
  <precision>2</precision>
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
  <objectName>tdec</objectName>
  <x>62</x>
  <y>224</y>
  <width>42</width>
  <height>26</height>
  <uuid>{e101a9b2-9d19-4345-91aa-5dc4bac0b2b6}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <label>0.010</label>
  <alignment>left</alignment>
  <valignment>top</valignment>
  <font>Arial</font>
  <fontsize>12</fontsize>
  <precision>2</precision>
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
  <objectName>asus</objectName>
  <x>97</x>
  <y>224</y>
  <width>41</width>
  <height>26</height>
  <uuid>{b5e8bb97-6ff2-41a6-9596-55e6d5802957}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <label>1.000</label>
  <alignment>left</alignment>
  <valignment>top</valignment>
  <font>Arial</font>
  <fontsize>12</fontsize>
  <precision>2</precision>
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
  <objectName>trel</objectName>
  <x>131</x>
  <y>224</y>
  <width>41</width>
  <height>26</height>
  <uuid>{f99cba85-cecf-4ee6-9028-046f9f6b76c0}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <label>0.204</label>
  <alignment>left</alignment>
  <valignment>top</valignment>
  <font>Arial</font>
  <fontsize>12</fontsize>
  <precision>2</precision>
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
  <objectName>tipo</objectName>
  <x>215</x>
  <y>34</y>
  <width>89</width>
  <height>30</height>
  <uuid>{daa2c7dc-24db-4ebf-a8d2-1c21744e2e1b}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <bsbDropdownItemList>
   <bsbDropdownItem>
    <name>ASR/AR</name>
    <value>0</value>
    <stringvalue/>
   </bsbDropdownItem>
   <bsbDropdownItem>
    <name>ADSR</name>
    <value>1</value>
    <stringvalue/>
   </bsbDropdownItem>
   <bsbDropdownItem>
    <name>ADSR-X</name>
    <value>2</value>
    <stringvalue/>
   </bsbDropdownItem>
  </bsbDropdownItemList>
  <selectedIndex>0</selectedIndex>
  <randomizable group="0">false</randomizable>
 </bsbObject>
 <bsbObject type="BSBLabel" version="2">
  <objectName/>
  <x>213</x>
  <y>14</y>
  <width>98</width>
  <height>24</height>
  <uuid>{c674ae73-46e4-4cf2-b7cb-35ee8762d877}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <label>Tipo de envolvente</label>
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
</bsbPanel>
<bsbPresets>
</bsbPresets>
