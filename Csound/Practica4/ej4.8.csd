<CsoundSynthesizer>
<CsOptions>
-W -o ej4.8.wav
</CsOptions>
<CsInstruments>
nchnls = 1
sr = 44100
0dbfs = 1

instr RUIDOS
	iAmp  = ampdbfs(p4) 
	iTipo = p5 
	
	aRuido init 0
	
	if iTipo == 1 then    
  		aRuido rand iAmp
	elseif(iTipo == 2) then                
   	aRuido pinkish iAmp
  elseif(iTipo == 3) then
   	aRuido noise iAmp, 0.995
  else
  		prints "NO ES UN RUIDO.\n"
	endif
	
endin

</CsInstruments>
<CsScore>
t  0  40

i "RUIDOS"  0    1    -9    1
i "RUIDOS"  +    1    -9    2
i "RUIDOS"  +    1    -9    3
i "RUIDOS"  +    1    -9    4

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
