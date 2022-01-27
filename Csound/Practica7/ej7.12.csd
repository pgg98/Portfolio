<CsoundSynthesizer>
<CsOptions>
-W -o ej7.12.wav
</CsOptions>
<CsInstruments>

nchnls = 2  ; sonido en estereo

; MULTI-TAP DELAY con delayr/delayw y 1 deltap

instr multitap
	SFich = p4
	iretard = p5
	itemp = p6
	ig0 = p7
	ig1 = p8
	ig2 = p9
	
	ain soundin SFich
	
	aig0 = ain*ig0
	
	aig2 delayr itemp
	
	aig1 deltap iretard
	
	delayw ain
	
	aig1 = aig1*ig1
	
	aig2 = aig2*ig2
	
	aig01 = aig0*0.5
	
	aoutL = aig01+aig1
	
	aig02 = aig0*0.5
	
	aoutR = aig02+aig2

  outs    aoutL,aoutR   ; canales izquierdo y derecho
endin

</CsInstruments>
<CsScore>

t 0 60   ; tempo = 60 BPM constante desde el principio

;3 repeticiones:
r 3
;     p1      p2  p3       p4         p5    p6    p7   p8   p9
;   instr    ini dur    fichero       tD1   tD2   g0   g1   g2  
;--------------------------------------------------------------
i "multitap"  0  3.3 "brighton.wav"  0.80  1.62   1  0.40  0.65

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
