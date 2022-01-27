<CsoundSynthesizer>
<CsOptions>
-W -o ej7.13.wav
</CsOptions>
<CsInstruments>

nchnls = 2  ; sonido en estéreo

; EL ARMONIZADOR

instr multiple
  iRTransA = p4           ; relacion de transposicion A
  iRTransB = p5           ; relacion de transposicion B
  iFFTSize = 1024         ; num. frecuencias calculadas
  iSolapa  = iFFTSize/4   ; solapamiento de la ventana
  iVenSize = iFFTSize     ; longitud de la ventana
  iVenTipo = 1            ; ventana tipo von Hann

  ain soundin  "tomorrow.wav"

	fs pvsanal ain,iFFTSize,iSolapa,iVenSize,iVenTipo
	fs2 pvsanal ain,iFFTSize,iSolapa,iVenSize,iVenTipo
		
	fs3 pvscale fs,iRTransA
	fs4 pvscale fs2,iRTransB
		
	aS1 pvsynth fs3
	aS2 pvsynth fs4
  
  aoutR=ain+aS1
  aoutL=ain+aS2
  
  outs aoutR,aoutL

endin


</CsInstruments>
<CsScore>

t 0 60  ; Tempo 60 BPM desde el principio

;     p1     p2  p3      p4         p5
;  instrum  ini dur    Rel_fA     Rel_fB 
;---------------------------------------------
i "multiple" 0 7 [46/32] [8/5]
i "multiple" + 7 [2^(10/12)] [2^(7/12)]

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
