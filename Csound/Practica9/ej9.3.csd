<CsoundSynthesizer>
<CsOptions>
-W -o ej9.3.wav
--midi-velocity-amp=4
--midi-key=5
-F pacman.mid
</CsOptions>
<CsInstruments>

sr = 44100
0dbfs = 1
massign 0, "controlMIDI"

instr controlMIDI
  iAmp    = p4              ; amplitud p4 (entre 0 y 0dbfs)
  kFrec   = cpsmidinn(p5)   ; de altura en p5 a frecuencia
  kOctava invalue "OCTAVA"
  kFrec   = kFrec*2^kOctava ; cambio de octava

 	aSal vco2 iAmp/2,kFrec, 10
 	outs aSal, aSal 

endin

</CsInstruments>
<CsScore>

t 0 106
e 8

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
 <bsbObject type="BSBSpinBox" version="2">
  <objectName>OCTAVA</objectName>
  <x>319</x>
  <y>57</y>
  <width>69</width>
  <height>30</height>
  <uuid>{237fbf21-fd5e-4374-ae86-d7aac1e0db82}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <alignment>left</alignment>
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
  <minimum>0</minimum>
  <maximum>3</maximum>
  <randomizable group="0">false</randomizable>
  <value>2</value>
 </bsbObject>
 <bsbObject type="BSBLabel" version="2">
  <objectName/>
  <x>317</x>
  <y>35</y>
  <width>80</width>
  <height>25</height>
  <uuid>{e3f27118-bb6b-4d97-93b9-391776c2de7d}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <label>OCTAVA</label>
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
  <x>12</x>
  <y>3</y>
  <width>295</width>
  <height>131</height>
  <uuid>{802c6142-893d-4dbf-828f-91bcd6bbb89f}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <label>TECLADO MIDI</label>
  <alignment>center</alignment>
  <valignment>top</valignment>
  <font>Arial Black</font>
  <fontsize>14</fontsize>
  <precision>3</precision>
  <color>
   <r>0</r>
   <g>0</g>
   <b>0</b>
  </color>
  <bgcolor mode="background">
   <r>249</r>
   <g>250</g>
   <b>253</b>
  </bgcolor>
  <bordermode>border</bordermode>
  <borderradius>1</borderradius>
  <borderwidth>3</borderwidth>
 </bsbObject>
 <bsbObject type="BSBButton" version="2">
  <objectName>NOTA</objectName>
  <x>20</x>
  <y>45</y>
  <width>40</width>
  <height>78</height>
  <uuid>{31c2b616-0042-43e9-8921-337c41d03424}</uuid>
  <visible>true</visible>
  <midichan>1</midichan>
  <midicc>0</midicc>
  <description/>
  <type>event</type>
  <pressedValue>1.00000000</pressedValue>
  <stringvalue/>
  <text>DO</text>
  <image>/</image>
  <eventLine>i "controlMIDI" 0 1 0.5 48</eventLine>
  <latch>false</latch>
  <latched>false</latched>
  <fontsize>10</fontsize>
 </bsbObject>
 <bsbObject type="BSBButton" version="2">
  <objectName>NOTA</objectName>
  <x>56</x>
  <y>45</y>
  <width>39</width>
  <height>78</height>
  <uuid>{c6139258-8e83-4038-bd7b-526e60c98c77}</uuid>
  <visible>true</visible>
  <midichan>1</midichan>
  <midicc>0</midicc>
  <description/>
  <type>event</type>
  <pressedValue>1.00000000</pressedValue>
  <stringvalue/>
  <text>RE</text>
  <image>/</image>
  <eventLine>i "controlMIDI" 0 1 0.5 50</eventLine>
  <latch>false</latch>
  <latched>false</latched>
  <fontsize>10</fontsize>
 </bsbObject>
 <bsbObject type="BSBButton" version="2">
  <objectName>NOTA</objectName>
  <x>90</x>
  <y>45</y>
  <width>39</width>
  <height>78</height>
  <uuid>{7a5557e1-95a2-43c7-a24c-717ce998c93a}</uuid>
  <visible>true</visible>
  <midichan>1</midichan>
  <midicc>0</midicc>
  <description/>
  <type>event</type>
  <pressedValue>1.00000000</pressedValue>
  <stringvalue/>
  <text>MI</text>
  <image>/</image>
  <eventLine>i "controlMIDI" 0 1 0.5 52</eventLine>
  <latch>false</latch>
  <latched>false</latched>
  <fontsize>10</fontsize>
 </bsbObject>
 <bsbObject type="BSBButton" version="2">
  <objectName>NOTA</objectName>
  <x>124</x>
  <y>45</y>
  <width>39</width>
  <height>78</height>
  <uuid>{13feac23-7c89-4be4-99d1-d2d7068f187f}</uuid>
  <visible>true</visible>
  <midichan>1</midichan>
  <midicc>0</midicc>
  <description/>
  <type>event</type>
  <pressedValue>1.00000000</pressedValue>
  <stringvalue/>
  <text>FA</text>
  <image>/</image>
  <eventLine>i "controlMIDI" 0 1 0.5 53</eventLine>
  <latch>false</latch>
  <latched>false</latched>
  <fontsize>10</fontsize>
 </bsbObject>
 <bsbObject type="BSBButton" version="2">
  <objectName>NOTA</objectName>
  <x>158</x>
  <y>45</y>
  <width>39</width>
  <height>78</height>
  <uuid>{86c43ec8-55d4-40ec-aa53-5039f95527dd}</uuid>
  <visible>true</visible>
  <midichan>1</midichan>
  <midicc>0</midicc>
  <description/>
  <type>event</type>
  <pressedValue>1.00000000</pressedValue>
  <stringvalue/>
  <text>SOL</text>
  <image>/</image>
  <eventLine>i "controlMIDI" 0 1 0.5 55</eventLine>
  <latch>false</latch>
  <latched>false</latched>
  <fontsize>10</fontsize>
 </bsbObject>
 <bsbObject type="BSBButton" version="2">
  <objectName>NOTA</objectName>
  <x>192</x>
  <y>45</y>
  <width>39</width>
  <height>78</height>
  <uuid>{9e1e1568-879c-44a7-98ae-a519e17dff85}</uuid>
  <visible>true</visible>
  <midichan>1</midichan>
  <midicc>0</midicc>
  <description/>
  <type>event</type>
  <pressedValue>1.00000000</pressedValue>
  <stringvalue/>
  <text>LA</text>
  <image>/</image>
  <eventLine>i "controlMIDI" 0 1 0.5 57</eventLine>
  <latch>false</latch>
  <latched>false</latched>
  <fontsize>10</fontsize>
 </bsbObject>
 <bsbObject type="BSBButton" version="2">
  <objectName>NOTA</objectName>
  <x>226</x>
  <y>45</y>
  <width>39</width>
  <height>78</height>
  <uuid>{5cb4dc8f-794e-4f6a-9e28-c1b428eee243}</uuid>
  <visible>true</visible>
  <midichan>1</midichan>
  <midicc>0</midicc>
  <description/>
  <type>event</type>
  <pressedValue>1.00000000</pressedValue>
  <stringvalue/>
  <text>SI</text>
  <image>/</image>
  <eventLine>i "controlMIDI" 0 1 0.5 59</eventLine>
  <latch>false</latch>
  <latched>false</latched>
  <fontsize>10</fontsize>
 </bsbObject>
 <bsbObject type="BSBButton" version="2">
  <objectName>NOTA</objectName>
  <x>260</x>
  <y>45</y>
  <width>40</width>
  <height>78</height>
  <uuid>{17c69c88-d24a-4f92-a58a-a08803d15caf}</uuid>
  <visible>true</visible>
  <midichan>1</midichan>
  <midicc>0</midicc>
  <description/>
  <type>event</type>
  <pressedValue>1.00000000</pressedValue>
  <stringvalue/>
  <text>DO</text>
  <image>/</image>
  <eventLine>i "controlMIDI" 0 1 0.5 60</eventLine>
  <latch>false</latch>
  <latched>false</latched>
  <fontsize>10</fontsize>
 </bsbObject>
 <bsbObject type="BSBButton" version="2">
  <objectName>NOTA</objectName>
  <x>41</x>
  <y>34</y>
  <width>32</width>
  <height>41</height>
  <uuid>{182700a9-d6d8-4432-a455-f6ca260a9bca}</uuid>
  <visible>true</visible>
  <midichan>1</midichan>
  <midicc>0</midicc>
  <description/>
  <type>event</type>
  <pressedValue>1.00000000</pressedValue>
  <stringvalue/>
  <text>#</text>
  <image>/</image>
  <eventLine>i "controlMIDI" 0 1 0.5 49</eventLine>
  <latch>false</latch>
  <latched>false</latched>
  <fontsize>10</fontsize>
 </bsbObject>
 <bsbObject type="BSBButton" version="2">
  <objectName>NOTA</objectName>
  <x>75</x>
  <y>34</y>
  <width>32</width>
  <height>41</height>
  <uuid>{8b7f2ca4-f3e4-44e6-92e8-7476e3487cfe}</uuid>
  <visible>true</visible>
  <midichan>1</midichan>
  <midicc>0</midicc>
  <description/>
  <type>event</type>
  <pressedValue>1.00000000</pressedValue>
  <stringvalue/>
  <text>#</text>
  <image>/</image>
  <eventLine>i "controlMIDI" 0 1 0.5 51</eventLine>
  <latch>false</latch>
  <latched>false</latched>
  <fontsize>10</fontsize>
 </bsbObject>
 <bsbObject type="BSBButton" version="2">
  <objectName>NOTA</objectName>
  <x>143</x>
  <y>32</y>
  <width>32</width>
  <height>41</height>
  <uuid>{2bb9512b-efa3-46bb-9ecf-0bbd1927a66a}</uuid>
  <visible>true</visible>
  <midichan>1</midichan>
  <midicc>0</midicc>
  <description/>
  <type>event</type>
  <pressedValue>1.00000000</pressedValue>
  <stringvalue/>
  <text>#</text>
  <image>/</image>
  <eventLine>i "controlMIDI" 0 1 0.5 54</eventLine>
  <latch>false</latch>
  <latched>false</latched>
  <fontsize>10</fontsize>
 </bsbObject>
 <bsbObject type="BSBButton" version="2">
  <objectName>NOTA</objectName>
  <x>177</x>
  <y>32</y>
  <width>32</width>
  <height>41</height>
  <uuid>{35829b1a-3045-4c3e-8691-9b24715a137d}</uuid>
  <visible>true</visible>
  <midichan>1</midichan>
  <midicc>0</midicc>
  <description/>
  <type>event</type>
  <pressedValue>1.00000000</pressedValue>
  <stringvalue/>
  <text>#</text>
  <image>/</image>
  <eventLine>i "controlMIDI" 0 1 0.5 56</eventLine>
  <latch>false</latch>
  <latched>false</latched>
  <fontsize>10</fontsize>
 </bsbObject>
 <bsbObject type="BSBButton" version="2">
  <objectName>NOTA</objectName>
  <x>212</x>
  <y>32</y>
  <width>32</width>
  <height>41</height>
  <uuid>{b926e905-e2e1-4eaf-8fd4-798b31ee9aa4}</uuid>
  <visible>true</visible>
  <midichan>1</midichan>
  <midicc>0</midicc>
  <description/>
  <type>event</type>
  <pressedValue>1.00000000</pressedValue>
  <stringvalue/>
  <text>#</text>
  <image>/</image>
  <eventLine>i "controlMIDI" 0 1 0.5 58</eventLine>
  <latch>false</latch>
  <latched>false</latched>
  <fontsize>10</fontsize>
 </bsbObject>
</bsbPanel>
<bsbPresets>
</bsbPresets>
