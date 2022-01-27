<CsoundSynthesizer>
<CsOptions>
-W -o ej5.15.wav  ; salida a este fichero WAV
</CsOptions>
<CsInstruments>

; inicializaciones de los parametros globales

sr = 44100  ; frecuencia de muestreo
ksmps  = 1  ; muestras calculadas en cada ciclo de control
nchnls = 1  ; sonido monoaural

instr ei

iamp=ampdbfs(p4)
ifrec=p5
ktime timek
ipi=$M_PI

aFi=2*ipi*ifrec*ktime/sr
aout=iamp*(1*sin(aFi)+1/3*sin(2*aFi))

out aout

print ifrec

endin

</CsInstruments>
<CsScore>

t 0 60 ; tempo constante = 60 BPM desde el principio

;   p1    p2   p3     p4      p5
;  ins   ini  dur amp(dBFS) frec.
;---------------------------------
i "ei" 0 2 -6.2 402
i "ei" 3 .   .  404
i "ei" 6 3   .  402
i "ei" . .   .  404

e

</CsScore>
</CsoundSynthesizer>
<bsbPanel>
 <label>Widgets</label>
 <objectName/>
 <x>100</x>
 <y>100</y>
 <width>320</width>
 <height>240</height>
 <visible>true</visible>
 <uuid/>
 <bgcolor mode="nobackground">
  <r>255</r>
  <g>255</g>
  <b>255</b>
 </bgcolor>
 <bsbObject type="BSBScope" version="2">
  <objectName/>
  <x>3</x>
  <y>5</y>
  <width>400</width>
  <height>200</height>
  <uuid>{9daca4b4-0e49-42bf-a1de-480252bcf792}</uuid>
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
