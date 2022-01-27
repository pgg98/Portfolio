<CsoundSynthesizer>
<CsOptions>
-W -o ej5.11.wav
</CsOptions>
<CsInstruments>

; inicializaciones de los parametros globales
; solo poner la frecuencia de muestreo
sr = 10000

instr ALIASING
iamp=ampdbfs(p4)
ifrec=p5
kyor timeinsts

if kyor < p3 then
	aout oscils iamp, ifrec, 0;genero F1
else
	aout oscils iamp-10, ifrec, 0;genero F2 con A2=A1-10 dB
endif
	
out aout

print iamp, sr-(ifrec*2)

endin

</CsInstruments>
<CsScore>

t 0 60

;PARA PROBAR LO DEL ALIASING
;    p1     p2  p3   p4   p5
; instrum  ini dur  amp  frec
;                  (dBFS)(Hz)
;-----------------------------
i "ALIASING"  0   1   -5   615
i      .      1   .    .   1845
i      .      2   .    .   3075

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
