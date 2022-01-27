<CsoundSynthesizer>
<CsOptions>
-W -o ej6.1.wav  ; salida a este fichero (si Render)
</CsOptions>
<CsInstruments>

;variables globales:
sr = 44100  ; f_s
ksmps = 128 ; se calculan 128 muestras por ciclo
0dbfs = 1   ; amplitud normalizada (maximo = 1)

opcode espectro, 0,a ; operador definido aqui para ver el espectro
  aSig  xin
        outvalue "outFT", 1
        dispfft  aSig, 0.1, 1024, 1, 0
endop


instr filtro1
  ifc   = p4  ; para recibir la frecuencia de corte
  ain soundin "rblanco.wav"
  aout butlp ain, ifc
  
  out aout
  
  espectro aout
endin


instr filtro2	
	sin soundin "rblanco.wav"
	ain1 delay ain
endin

</CsInstruments>
<CsScore>

;   ins    ini dur  f_c
;------------------------
i "filtro1"  0   2  10000 
i "filtro1"  3   2   1000 
i "filtro1"  6   2    200 

e

</CsScore>
</CsoundSynthesizer>
<bsbPanel>
 <label>Widgets</label>
 <objectName/>
 <x>646</x>
 <y>442</y>
 <width>654</width>
 <height>393</height>
 <visible>true</visible>
 <uuid>{a34025d3c6cfbfc143e7f4cc6c24f135}</uuid>
 <bgcolor mode="nobackground">
  <r>255</r>
  <g>250</g>
  <b>228</b>
 </bgcolor>
 <bsbObject version="2" type="BSBScope">
  <objectName>audio_out</objectName>
  <x>111</x>
  <y>7</y>
  <width>407</width>
  <height>148</height>
  <uuid>{2103ab27-bd9e-4650-ab43-545afafb7b7d}</uuid>
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
  <objectName>outFT</objectName>
  <x>111</x>
  <y>160</y>
  <width>407</width>
  <height>203</height>
  <uuid>{282e9bc0-e49b-4ef1-b14c-923f3091036e}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <value>1</value>
  <objectName2>tab_outFT</objectName2>
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
 <bsbObject version="2" type="BSBLabel">
  <objectName/>
  <x>20</x>
  <y>20</y>
  <width>80</width>
  <height>25</height>
  <uuid>{ef576f8a-9ba9-4f7c-b696-06c7064cd150}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <label>ONDA:</label>
  <alignment>left</alignment>
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
  <bordermode>noborder</bordermode>
  <borderradius>1</borderradius>
  <borderwidth>0</borderwidth>
 </bsbObject>
 <bsbObject version="2" type="BSBLabel">
  <objectName/>
  <x>17</x>
  <y>179</y>
  <width>87</width>
  <height>26</height>
  <uuid>{a084513a-a5cd-4878-a0ff-ff226c0dd928}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <label>ESPECTRO:</label>
  <alignment>left</alignment>
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
  <bordermode>noborder</bordermode>
  <borderradius>1</borderradius>
  <borderwidth>0</borderwidth>
 </bsbObject>
</bsbPanel>
<bsbPresets>
</bsbPresets>
