<CsoundSynthesizer>
<CsOptions>
-W -o ej9.9.wav
</CsOptions>
<CsInstruments>

sr = 44100
ksmps = 10
0dbfs = 32768

giNota init -1
gSMsgNota[] init 4
gSMsgNota fillarray "Nota 1: solo se percibe un vibrato.",
                    "Nota 2: se percibe un vibrato creciente. Se va distorsionando el espectro.",
                    "Nota 3: FM armonica con Imod decreciente. Se van perdiendo armonicos.",
                    "Nota 4: FM inarmonica con Imod creciente. Los parciales van aumentando."

; SINTESIS FM CON 2 OSCILADORES

instr FM
  iDur    = p3  ; Duracion
  iAmp    = p4  ; Amplitud de la portadora
  iFc     = p5  ; Frecuencia de la portadora
  iFm     = p6  ; Frecuencia de la moduladora
  iAm1    = p7  ; Amplitud de modulacion inicial
  iAm2    = p8  ; Amplitud de modulacion final
  
  kres line iAm1, iDur, iAm2
  
  amod oscil3 kres, iFm
  
  amod = amod*iFc
  
  aSal0 oscil3 iAmp, amod
  
  aSal linen aSal0, 0.05, iDur, 0.1  



          out      aSal             ; salida del sonido
          dispfft  aSal, 0.1, 1024  ; dibujo del espectro
          giNota = giNota+1
          outvalue "NNOTA", gSMsgNota[giNota]
          outvalue "IMOD1",iAm1/iFm
          outvalue "IMOD2",iAm2/iFm
          outvalue "FCFM",iFc/iFm
endin

</CsInstruments>
<CsScore>

t 0 25  ; tempo = 25 BPM constante desde el principio

;  p1   p2  p3   p4   p5   p6    p7    p8
; inst ini dur  Amp   fc   fm   Am1   Am2
;------------------------------------------
i "FM" 0.0  2  18000 500   4    20    20       ; vibrato
i  .   2.5  .    .    .    10   5     5000       ; de vibrato a FM
i  .   5.0  .    .    .    500  5000  250           ; FM armonica 
i  .   7.5  .    .    .   707.1067812  353.5533906  2828.427125                ; FM inarmonica 

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
  <r>255</r>
  <g>255</g>
  <b>255</b>
 </bgcolor>
 <bsbObject type="BSBGraph" version="2">
  <objectName/>
  <x>9</x>
  <y>11</y>
  <width>500</width>
  <height>200</height>
  <uuid>{635809e0-17c9-4e27-8f19-e21b6bcf5001}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <value>0</value>
  <objectName2/>
  <zoomx>1.50000000</zoomx>
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
  <objectName>NNOTA</objectName>
  <x>8</x>
  <y>215</y>
  <width>502</width>
  <height>30</height>
  <uuid>{3b8090bf-bc09-44f5-a8d5-4051309b2c21}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>-3</midicc>
  <description/>
  <label>Nota 3: FM armonica con Imod decreciente. Se van perdiendo armonicos.</label>
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
  <x>69</x>
  <y>249</y>
  <width>37</width>
  <height>26</height>
  <uuid>{0336f407-cde1-45d7-8be0-a22d200a3163}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>-3</midicc>
  <description/>
  <label>I1 =</label>
  <alignment>left</alignment>
  <valignment>top</valignment>
  <font>Georgia</font>
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
 <bsbObject type="BSBDisplay" version="2">
  <objectName>IMOD1</objectName>
  <x>99</x>
  <y>249</y>
  <width>57</width>
  <height>28</height>
  <uuid>{513eafe4-2379-46e6-b7d7-480964db9b67}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>-3</midicc>
  <description/>
  <label>10.000</label>
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
 <bsbObject type="BSBLabel" version="2">
  <objectName/>
  <x>192</x>
  <y>249</y>
  <width>37</width>
  <height>26</height>
  <uuid>{b8a3ea26-e7ef-4128-a5bb-93f327d8176d}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>-3</midicc>
  <description/>
  <label>I2 =</label>
  <alignment>left</alignment>
  <valignment>top</valignment>
  <font>Georgia</font>
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
 <bsbObject type="BSBDisplay" version="2">
  <objectName>IMOD2</objectName>
  <x>222</x>
  <y>249</y>
  <width>57</width>
  <height>28</height>
  <uuid>{896445ba-02b5-493b-8dbf-a8089a9930e0}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>-3</midicc>
  <description/>
  <label>0.500</label>
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
 <bsbObject type="BSBLabel" version="2">
  <objectName/>
  <x>315</x>
  <y>250</y>
  <width>59</width>
  <height>25</height>
  <uuid>{8383dd09-f08d-4c95-b2c9-cf263c7d0473}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>-3</midicc>
  <description/>
  <label>fc/fm =</label>
  <alignment>left</alignment>
  <valignment>top</valignment>
  <font>Georgia</font>
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
 <bsbObject type="BSBDisplay" version="2">
  <objectName>FCFM</objectName>
  <x>371</x>
  <y>249</y>
  <width>57</width>
  <height>28</height>
  <uuid>{82264383-38d1-4f1d-a75a-3d2a7ff30f6c}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>-3</midicc>
  <description/>
  <label>1.000</label>
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
