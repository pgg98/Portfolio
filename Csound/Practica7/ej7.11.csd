<CsoundSynthesizer>
<CsOptions>
-W -o ej7.11.wav
</CsOptions>
<CsInstruments>

nchnls = 1  ; sonido en mono
sr = 44100  ; frecuencia de muestreo
ksmps  = 1  ; en cada ciclo de control se calcula una sola muestra

instr ducking
  iUmbdB  = p4   ; umbral en dBFS enviado desde la partitura
  iRatio  = p5   ; tasa de compresion
  SFich   = p6   ; nombre del fichero con el sonido a comprimir
  iUmbPCM = ampdbfs(iUmbdB) ; calculo del umbral en PCM
  
  avoz soundin "vozdj.wav"
  ason soundin SFich

  if iUmbPCM>0 then
    kganan rms avoz, iRatio
  else
    kganan = 1
  endif
  
  ason=ason*kganan
  
  aout=ason+avoz
  
  out aout

endin

</CsInstruments>
<CsScore>

t 0 60 ; tempo 60 desde el inicio

;    p1     p2  p3   p4       p5        p6
;  instr   ini dur  umbral  ratio    fichero
;---------------------------------------------
i "ducking" 0 14.0 0 [1/1] "mix.wav"

e

</CsScore>
</CsoundSynthesizer>
<bsbPanel>
 <label>Widgets</label>
 <objectName/>
 <x>17</x>
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
