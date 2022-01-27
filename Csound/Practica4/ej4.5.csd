<CsoundSynthesizer>
<CsOptions>
-n
</CsOptions>
<CsInstruments>

sr = 8000
ksmps = 80

instr Hola
SHola = "Hola"
iCinco = 5
print iCinco
prints "%s. Este es el ejercicio %d.%d\n", SHola, 4, iCinco

kValor init 0
kValor = kValor+1
printk 0.1, kValor
endin

</CsInstruments>
<CsScore>
i  "Hola"  0  1
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
 <uuid/>
 <bgcolor mode="nobackground">
  <r>255</r>
  <g>255</g>
  <b>255</b>
 </bgcolor>
</bsbPanel>
<bsbPresets>
</bsbPresets>
