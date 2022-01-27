<CsoundSynthesizer>
<CsOptions>
-W -o ej7.9.wav
</CsOptions>
<CsInstruments>

nchnls = 1  ; sonido en mono
sr = 44100

; ECO MULTIPLE CON FILTRO PEINE IIR

instr flanger
  SFich  = p4      ; nombre del fichero de entrada
  igR    = p5      ; ganancia de la entrada
  itD    = p6 ; tiempo de retardo (ms --> s)
  iamp   = p7
  ifrec  = p8
  aout init 0      ; inicializacion de la onda de salida (por la realimentacion)

  ain soundin SFich
  
  kfmod lfo iamp, ifrec, 0
  
  kfmod = itD+kfmod
  
  aout vdelay ain, kfmod, itD+iamp
  
  out aout

endin

</CsInstruments>
<CsScore>

t 0 60   ; tempo = 60 BPM constante desde el principio

;     p1     p2   p3         p4        p5  p6    p7     p8
;  instrum  ini  dur      fichero      gR  tD  max_desv fm
;------------------------------------------------------
i "flanger"  0   7  "limelight.wav"  0.83 3.4  2.2  0.36    

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
