<CsoundSynthesizer>
<CsOptions>
-W -o ej7.8.wav
</CsOptions>
<CsInstruments>

nchnls = 2  ; sonido en estereo (generamos 2 canales!)

instr play
  SFich = p4
  ain soundin SFich
      outs    ain, ain
endin

; REVERBERACION POR CONVOLUCION USANDO pconvolve 

instr auralizar
  SFich  = p4
  SRImp  = p5
  iLVent = 1024
  
  ain soundin SFich
  
  aoutL, aoutR pconvolve ain, SRImp, iLVent
  
  aoutL = ain+aoutL
  
  aoutR = ain+aoutR

  outs      aoutL, aoutR
endin


</CsInstruments>
<CsScore>

t 0 60   ; tempo = 60 BPM constante desde el principio

;     p1      p2    p3          p4             p5
;   instr    ini   dur      Fich.sonido   Fich.R.Impulso
;--------------------------------------------------------
i "play"      0      3         "marimba.wav" 
i "auralizar" 4    3.328    "marimba.wav" "hn-estudio.wav"        

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
</bsbPanel>
<bsbPresets>
</bsbPresets>
