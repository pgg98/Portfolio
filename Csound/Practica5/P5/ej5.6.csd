<CsoundSynthesizer>
<CsOptions>
-W -o ej5.6.wav  ; salida a este fichero WAV
</CsOptions>
<CsInstruments>

; inicializaciones de los parametros globales

sr = 44100  ; frecuencia de muestreo
ksmps  = 1  ; muestras calculadas en cada ciclo de control
nchnls = 1  ; sonido monoaural

; INSTRUMENTO PARA CREAR UNA ONDA SENO DE F Y A CONSTANTES

instr seno
  iAmp   = ampdbfs(p4) ; se recibe en dBFS y se convierte a PCM
  iFrec  = cpspch(p5)  ; se recibe altura y se convierte en Hz
  ipi    = $M_PI       ; macro que contiene el valor de pi
  
  ires timek
  
  s=iAmp*SENO(2*ipi*iFrec*ires/44100)
  
  out s

endin

</CsInstruments>
<CsScore>

; tempo constante desde el principio segun se indique
t 0 115
; activa el instrumento seno durante los tiempos indicados

; instr  ini  dur amp(dBFS) altura
;   p1    p2   p3     p4      p5
;---------------------------------
i "seno"  0	   3.00		-5.1			9.00

e

</CsScore>
</CsoundSynthesizer>
<bsbPanel>
 <label>Widgets</label>
 <objectName/>
 <x>16</x>
 <y>17</y>
 <width>320</width>
 <height>240</height>
 <visible>true</visible>
 <uuid>{a34025d3c6cfbfc143e7f4cc6c24f135}</uuid>
 <bgcolor mode="nobackground">
  <r>255</r>
  <g>255</g>
  <b>255</b>
 </bgcolor>
 <bsbObject type="BSBScope" version="2">
  <objectName/>
  <x>5</x>
  <y>5</y>
  <width>400</width>
  <height>200</height>
  <uuid>{7fbb8ca058db819baa08365bed246e5a}</uuid>
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
