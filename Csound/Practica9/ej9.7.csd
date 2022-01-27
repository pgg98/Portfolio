<CsoundSynthesizer>
<CsOptions>
-W -o ej9.7.wav
</CsOptions>
<CsInstruments>

sr = 48000
kr = 4800
0dbfs = 32768

;            NumT, ini, L, GEN, Armonicos
giSeno ftgen  100,  0,  8,  10,  1 ; un ciclo de sinusoidal con GEN10

giSierra ftgen 101, 0, 64, 10, 1,1/2,1/3,1/4,1/5,1/6

giForma ftgen 102,0,128, 7, 0.000000, 20, 0.406061, 18, 0.109091, 11, 1.000000, 14, -0.860606, 10, -0.206061, 20, -0.709091, 35, 0.000000


instr wavetable
  iDur   = p3
  iAmp   = ampdbfs(p4)  ; de dBFS a valor de amplitud PCM
  iFrec  = cpspch(p5)   ; de octava.nota a Hercios
  iTabla = p6
  ita = 0.02*iDur
  itr = 0.1*iDur
  
  //ares phasor iFrec 
  
  //ares2 table3 ares, iTabla, 1
  
  ares2 oscil3 iAmp, iFrec, iTabla 
  
  ares2 = ares2*iAmp
  
  kres linen 1, ita, iDur, itr 
  
  ares2 = ares2*kres
  
  out ares2
 

endin

</CsInstruments>
<CsScore>

t 0 60 ; tempo = 60 BPM constante desde el principio

;      p1     p2   p3   p4   p5  
;    instr   ini  dur  amp  nota 
;---------------------------------------
i "wavetable" 0   2.0   -6  7.10 100
i "wavetable" +   2.0  -5.9 7.07 101
i "wavetable" +   2.0   -4  7.03 102

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
 <bsbObject type="BSBScope" version="2">
  <objectName/>
  <x>5</x>
  <y>5</y>
  <width>400</width>
  <height>200</height>
  <uuid>{79b80896-933e-4b65-8658-f424467a90d4}</uuid>
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
</bsbPanel>
<bsbPresets>
</bsbPresets>
