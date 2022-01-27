<CsoundSynthesizer>
<CsOptions>
-n  ; no hay salida de sonido
</CsOptions>
<CsInstruments>

sr = 22050         ; Pon la frecuencia de muestreo de tu fichero wav
ksmps = 1     ; En cada ciclo de control se calcula una sola muestra
0dbfs = 2^15  ; Amplitud maxima (32768)

instr muestras
  SFin   = "ej5.2-in.wav"   ; Fichero WAV a analizar
  SFout  = "ej5.2-out.txt"  ; Fichero TXT donde se escriben las muestras

  aSenal soundin SFin
  kmuestras = aSenal
  
   fprintks "SFin", "%d\n", kmuestras

endin

</CsInstruments>
<CsScore>

; Activa el instrumento muestras durante el tiempo que dure tu fichero.
; Al no poner orden t --> Tempo = 60 BPM --> tiempos = segundos 

;   inst    inic  dura 
;    p1      p2    p3  
;----------------------
i "muestras"  0   0.1   

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
</bsbPanel>
<bsbPresets>
</bsbPresets>
