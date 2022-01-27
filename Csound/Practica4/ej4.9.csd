<CsoundSynthesizer>
<CsOptions>
-W -o ej4.9.wav
</CsOptions>
<CsInstruments>
nchnls = 2
sr = 44100
0dbfs = 1
ksmps = 180  ; (las variables k- se recalculan cada 180 muestras)

instr principio
	prints "Esperamos 1 s\n" 
	giFrec = cpspch(9.07)	
endin

instr panoramico
	print giFrec
	iAmp = 0.8
	kPan line 0,p3,1
	printk 0.5, kPan 
	aSal poscil iAmp, giFrec
	outs aSal*kPan, aSal*(1-kPan)
endin

</CsInstruments>
<CsScore>
t  0  60

i "principio"  0    1 
i "panoramico"  +    3.1

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
