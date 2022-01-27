<CsoundSynthesizer>
<CsOptions>
-W -o ej6.9.wav ; Fichero de salida si Render
</CsOptions>
<CsInstruments>

; Parametros de cabecera:
sr = 44100 ; frecuencia de muestreo
ksmps =  1 ; muestras por ciclo
0dbfs =  1 ; maxima amplitud del rango

; OPERADOR DEFINIDO AQUI: Calcula la ganancia a una frecuencia
opcode GananciaF, 0,ai
  as,iF  xin
  iTdeF  = 2*iF/sr
  kT     times
  kMetro metro  250
  kEnv   max_k  as, kMetro, 1
  if kT=iTdeF then
    kGdB = dbfsamp(kEnv)
    printks "Ganancia para %d Hz = %d dB\n\n",0,iF,kGdB
  endif
endop

instr cascada

	SFich = p4
	ifc = p5
	
	ain soundin SFich
	
	aout butlp ain, ifc 
	
	aout2 butlp aout, ifc
	
	aout3 butlp aout2, ifc
	
	out aout3
	
	GananciaF aout3, ifc

endin

</CsInstruments>
<CsScore>

t 0 60   ; tempo 60 BPM (1 tiempo = 1 segundo)

;     p1    p2  p3    p4         p5
;  instrum ini dur  fichero   f_corte
;--------------------------------------
i "cascada" 0 1 "f_var.wav" 10000

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
