<CsoundSynthesizer>
<CsOptions>
-n ; no se genera ningun sonido
</CsOptions>
<CsInstruments>

sr = 44100  ; f muestreo
0dbfs = 2^15 ; 32768 

instr Apico
  SFich  = p4   ; parametro que recibe el nombre del fichero a analizar
	
	aSonido soundin "guitarra_E2.wav"
	kApico peak aSonido
	kCambio changed kApico

  if kCambio=1 then 
		kTiempo times

    printks "t(seg) = %5.3f  Apico = %d PCM,  %6.2f dBFS\n", 0, \
            kTiempo, kApico, 20*log10(kApico/0dbfs)
  endif
  out  aSonido  ; solo para monitorizar el audio de entrada
endin

</CsInstruments>
<CsScore>

; Activa el instrumento Apico enviando el nombre del fichero a analizar.
; La duracion de la activacion debe ser igual a la indicada en la pregunta.

; En p2 va el tiempo de inicio de la activacion
; En p3 va la duracion en segundos de la activacion
; En p4 va el nombre del fichero a analizar

;  inst   inic  durac nom.fichero    
;   p1     p2    p3      p4  
;--------------------------------
i "Apico"   0    2.0  "guitarra_E2.wav" 

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
