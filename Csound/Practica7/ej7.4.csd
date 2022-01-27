<CsoundSynthesizer>
<CsOptions>
-W -o ej7.4.wav
</CsOptions>
<CsInstruments>

; MEDIDOR DE FRECUENCIA MAXIMA
opcode frec_max, 0,a
  as xin
  kFmax init 0
  kTime  timeinsts
  if kTime > 1.5 && kTime < p3-1.5 then
    kFrec,kAmp  pitchamdf  as,100,500
    kFmax   peak  kFrec
    printk2 round(kFmax)
  endif
endop

; PARA EL VIBRATO POR DOPPLER
instr vibrato

	SFich = p4
	iDes = p5
	iFrec = p6
	
	ain soundin SFich
	
	ktim timeinsts
	
	if ktim < 1 then 
		kfmod = 1
	else
		kfmod lfo iDes, iFrec, 0
	endif
	
	amodul=iDes+kfmod
	
	aout vdelay ain, amodul, 3*iDes
	
	out aout

  frec_max aout
endin

</CsInstruments>
<CsScore>

t 0 60  ; tempo = 60 BPM desde el principio

;     p1    p2  p3       p4       p5   p6
;   instr  ini dur    fichero   A_des fvib
;              (s)               (ms) (Hz)
;-------------------------------------------
i "vibrato" 0  4.0  "cello.wav"   0.1  0.0 
i "vibrato" 4.0 4.0 "cello.wav"   1.5  3.0

e

</CsScore>
</CsoundSynthesizer>
<bsbPanel>
 <label>Widgets</label>
 <objectName/>
 <x>1</x>
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
