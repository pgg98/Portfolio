<CsoundSynthesizer>
<CsOptions>
-W -o ej7.6.wav
</CsOptions>
<CsInstruments>

nchnls = 1  ; sonido en mono

; ECO SIMPLE MEDIANTE FILTRO PEINE FIR

instr ecosimple
  SFich  = p4  ; nombre del fichero de entrada
  igE    = p5  ; ganancia de la entrada
  igR    = p6  ; ganancia de la retrasada
  itD    = p7  ; tiempo de retardo

	ain soundin SFich
	
	adelay delay ain, itD 
	
	adelay = adelay*igR
	
	asin = ain*igE
	
	aout = adelay+asin

         out    aout
endin

</CsInstruments>
<CsScore>

t 0 60   ; tempo = 60 BPM constante desde el principio
         ; para que los inicios y duraciones esten en segundos

;      p1      p2     p3          p4       p5   p6   p7
;     ins     ini    dur       fichero     gE   gR   tD
;---------------------------------------------------------
i "ecosimple"  0    5.601 "gotas.wav"     1.0   0.0  0.001
i "ecosimple"  +    5.795 "gotas.wav"     1.0   0.3  0.195
i "ecosimple"  +    6.02  "gotas.wav"     0.5   1.4  0.42

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
