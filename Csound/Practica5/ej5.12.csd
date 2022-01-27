<CsoundSynthesizer>
<CsOptions>
-W -o ej5.12.wav
</CsOptions>
<CsInstruments>

; inicializaciones de los parametros globales

sr = 44100  ; frecuencia de muestreo
ksmps  = 1  ; muestras calculadas en cada ciclo de control
nchnls = 1  ; sonido monoaural

; Generador aleatorio de notas ligadas

instr ligadas
  iAmp    = ampdbfs(-6) ; de dBFS a PCM
  iNota1  = p4            ; en altura MIDI
  iNota2  = p5            ; en altura MIDI
  iFCamb  = p6            ; en notas/s

	kres randomh iNota2, iNota1, iFCamb
	ifrec1 round(kres)
	ifrec2 cpsmidinn(ifrec1)
	kresul lineto ifrec2, 0.02
	
	aOut poscil iAmp, kresul
	

          out     aOut
endin

</CsInstruments>
<CsScore>

t 0 60 ; tempo constante desde el principio = 60 BPM --> 1 tiempo = 1 s

;     p1    p2  p3   p4    p5     p6
;  instrum ini dur  alt1  alt2 Fcambio
;                    ( MIDI )  notas/s
;--------------------------------------
i "ligadas" 0   10   103   72     8

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
 <bsbObject version="2" type="BSBScope">
  <objectName/>
  <x>7</x>
  <y>33</y>
  <width>350</width>
  <height>150</height>
  <uuid>{691704d0-f73a-41f8-8ba6-60aed033e0aa}</uuid>
  <visible>true</visible>
  <midichan>0</midichan>
  <midicc>0</midicc>
  <description/>
  <value>-255.00000000</value>
  <type>scope</type>
  <zoomx>2.00000000</zoomx>
  <zoomy>1.00000000</zoomy>
  <dispx>1.00000000</dispx>
  <dispy>1.00000000</dispy>
  <mode>0.00000000</mode>
 </bsbObject>
</bsbPanel>
<bsbPresets>
</bsbPresets>
