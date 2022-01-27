<CsoundSynthesizer>
<CsOptions>
-W -o ej7.10.wav
</CsOptions>
<CsInstruments>

nchnls = 1  ; sonido en mono

seed 2

instr wahwah 
 SFich  = p4
 iFcent = p5   ; frecuencia central del filtro
 iAncho = p6   ; ancho de banda
 prints "Q filtro = %3.1f\n", iFcent/iAncho ; imprime la Q del filtro sin modular
 ia     = p7   ; coeficiente de amplitud (a) de la senal filtrada
 iDesv  = p8   ; Maximo desvio de la Frecuencia central
 iFmod  = p9   ; Frecuencia de modificacion de la Frecuencia central
 
 ain soundin SFich
 
 kran randi iDesv, iFmod 
 
 kran = iFcent+kran
 
 ares reson ain, kran, iAncho, 2
 
 ares=ares*ia
 
 aleft=ain*(1-ia)
 
 aout=ares+aleft
 
 out aout 

endin

</CsInstruments>
<CsScore>

t 0 60   ; tempo = 60 BPM constante desde el principio

;    p1     p2  p3      p4     p5   p6  p7   p8   p9
; instrum  ini dur   fichero   fc  A.B.  a   DF   FM
;-----------------------------------------------------
i "wahwah" 0   8 "guitar1.wav" 1450 250 0.30 1250 1.82 

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
