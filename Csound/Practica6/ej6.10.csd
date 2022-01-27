<CsoundSynthesizer>
<CsOptions>
-W -o ej6.10.wav ; Fichero generado si Render
</CsOptions>
<CsInstruments>

ksmps  = 1

; Instrumento PASA-TODA

instr fptoda
	SFich = p4
	ig = p5
	itr = p6/1000
	
	ain soundin SFich
	
	ain=0.9*ain
	
	aout init 0
	
	aout alpass ain, ig, itr
	
	out aout
endin

</CsInstruments>
<CsScore>

t 0 60 ; tempo = 60 BPM --> 1 tiempo = 1 segundo

;    p1     p2  p3      p4       p5     p6
;   ins    ini dur   fichero    gain  tD(ms)
;---------------------------------------------
i "fptoda" 0 1 "f_var.wav" 0.02 10
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
