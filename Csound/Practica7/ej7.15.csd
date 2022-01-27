<CsoundSynthesizer>
<CsOptions>
-W -o ej7.15.wav
</CsOptions>
<CsInstruments>

instr ecualizador
SFich=p4
iFrec=p5
igan=p6
ianch=p7
iganPCM=ampdb(p6)

iq=iFrec/ianch

ain soundin p4

asound pareq ain,p5,p6,(p5/p7)

print iq, iganPCM

out asound

endin

</CsInstruments>
<CsScore>

t 0 60   ; tempo = 60 BPM constante desde el principio

;      p1        p2  p3       p4        p5   p6   p7 
;    instr      ini dur    fichero      fc    G    W
;                                      (Hz) (dB) (Hz)
;-----------------------------------------------------
i "ecualizador"  0  7.0  "mezcla.wav" 1000  0   1000
i "ecualizador"  +  7.0  "mezcla.wav" 2200  12.5 1000
i "ecualizador"  +  7.0  "mezcla.wav" 100   -14  150

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
