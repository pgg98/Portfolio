<CsoundSynthesizer>
<CsOptions>
-W -o ej5.13.wav
</CsOptions>
<CsInstruments>

; inicializaciones de los parametros globales

sr = 44100  ; frecuencia de muestreo
ksmps  = 1  ; muestras calculadas en cada ciclo de control
nchnls = 1  ; sonido monoaural

; INSTRUMENTO PARA CREAR UNA ONDA COMPUESTA

instr COMPUESTA
  iAmp   = ampdbfs(p4) ; se recibe en dB y se convierte a PCM
  iFrec  = p5          ; se recibe en Hz
  iNParc = p6          ; numero de armonicos a utilizar
  ipi    = $M_PI       ; valor de pi
  icont = 1
  ivalor = 0
  
  
  while icont<=iNParc do
  		ivalor=ivalor+iAmp*sin(ipi)
  		icont=icont+1
  	od
  		
  aout oscil iAmp, ivalor
  
  out aout 

endin

</CsInstruments>
<CsScore>

t 0 140; Pon el tempo que corresponda

; activa el instrumento 13

;     p1       p2  p3   p4   p5   p6
;  instrum    ini dur  amp  Frec  NP
;                    (dBFS) (Hz)
;--------------------------------------
i  "COMPUESTA" 0   1   -6.6  196  4

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
  <x>5</x>
  <y>5</y>
  <width>400</width>
  <height>200</height>
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
