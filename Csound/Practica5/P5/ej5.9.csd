; PARA ELIMINAR LOS CLICKS DE LA ESCALA
<CsoundSynthesizer>
<CsOptions>
-W -o ej5.9.wav
</CsOptions>
<CsInstruments>

; inicializaciones de los parametros globales

sr = 44100  ; frecuencia de muestreo
ksmps  = 1  ; muestras calculadas en cada ciclo de control
nchnls = 1  ; sonido monoaural

; INSTRUMENTO PARA CREAR UNA ONDA SENO DE F Y A CONSTANTES CON ENVOLVENTE

instr NOTA
  iAmp  = ampdbfs(p4) ; se recibe en dB y se convierte a PCM
  iFrec = p5          ; se recibe en Hz
  ipi   = $M_PI       ; contiene el valor de pi
  
  ; Se deben definir aqui los datos particulares de la envolvente (tipo i)
  
  iAtak = p6
  iRelaj = p8
  iDur = p3
  
	kres linen iAmp, iAtak, iDur, iRelaj

   aOut  oscils iAmp, iFrec, 0
          


        out    aOut*kres
endin

</CsInstruments>
<CsScore>
t 0 85

;PARA SINTETIZAR UNA ESCALA

#define ref #261.6#

;   p1   p2   p3    p4       p5       p6   p7   p8
; instr ini  dur   amp      frec    tAtaq Asus tRel
;                 (dBFS)    (Hz)     (s)        (s)
;----------------------------------------------------
i "NOTA" 0   0.5    -1      $ref     0.04  0.75   0.1
i   .    +    .      .   [$ref*9/8]   .      .     .
i   .    +    .      .   [$ref*5/4]   .      .     .
i   .    +    .      .   [$ref*4/3]   .      .     .
i   .    +    .      .   [$ref*3/2]   .      .     .
i   .    +    .      .   [$ref*5/3]   .      .     .
i   .    +    .      .   [$ref*15/8]  .      .     .
i   .    +    .      .    [$ref*2]    .      .     .

e

</CsScore>
</CsoundSynthesizer>
<bsbPanel>
 <label>Widgets</label>
 <objectName/>
 <x>179</x>
 <y>184</y>
 <width>400</width>
 <height>300</height>
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
