<CsoundSynthesizer>
<CsOptions>
-W -o ej7.14.wav
</CsOptions>
<CsInstruments>

sr = 44100
nchnls = 2

instr sinefecto
  ain  soundin "saxo.wav"
  aout = ain
  outs aout,aout
endin

instr conefecto
  ivol  = p4
  itR   = p5
  ifc   = p6
  iAng  = p7/90*$M_PI_2 ; esto es pi/2
  igL = ((iAng*90)/100)/100
  igR = 1-igL
  
  ain soundin "saxo.wav"
  
  ain = ain*ivol
  
  aout0 nreverb ain, itR, 0 
  
  aout1 tone aout0, ifc 
  
  aoutL = aout1*igL
  
  aoutR = aout1*igR
  
  out aoutL, aoutR

  print igL, igR
endin

</CsInstruments>
<CsScore>

;   instrum   ini  dur  vol   fc  tR  ang
;     p1       p2   p3   p4   p5  p6   p7
;==========================================
i "sinefecto"  0   3.0 ; este no tiene mas parametros
i "conefecto"  +   5.0  0.9  5000 0.1 26
i "conefecto"  +   5.0  0.6  500  1.0 81

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
</bsbPanel>
<bsbPresets>
</bsbPresets>
