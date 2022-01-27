<CsoundSynthesizer>
<CsOptions>
-W -o ej7.1.wav
</CsOptions>
<CsInstruments>

nchnls = 1  ; sonido en mono
sr = 44100  ; frecuencia de muestreo
ksmps = 10  ; en cada ciclo de control se calculan 10 muestras

instr tremolo
  SFich = p4  ; Nombre del fichero a procesar
  iGm   = p5
  iAm   = p6  ; Amplitud de la modulacion
  iFm   = p7  ; Frecuencia dfe la modulacion
  
  	ain soundin SFich
	kFmod lfo iAm, iFm
	aganancia = iGm + kFmod
	aout=ain*aganancia
	
	out aout
	

endin

</CsInstruments>
<CsScore>

t 0 60 ; tempo 60 desde el inicio
 
;     p1     p2  p3      p4       p6   p7
;  instrum  ini dur   fichero    Amod fmod
;------------------------------------------
i "tremolo" 0 8 "flauta.wav" 0.9 0 0
i "tremolo" 8 8 "flauta.wav" 0.9 0.5 7.5

e

</CsScore>
</CsoundSynthesizer>
<bsbPanel>
 <label>Widgets</label>
 <objectName/>
 <x>1</x>
 <y>1</y>
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
