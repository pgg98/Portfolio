<CsoundSynthesizer>
<CsOptions>
-g -W -o ej9.10.wav
</CsOptions>
<CsInstruments>

nchnls = 2 ; orquesta estereo

; SAMPLER CON KEYMAP POR OCTAVAS

instr sampler
  iDur   = p3
  iAmp   = ampdbfs(p4)        ; de dBFS en p4 a valor de amplitud PCM
  iOct   = floor(p5-4)        ; octava 2..5
  iSemit = frac(p5)*100        ; semitonos
  iTrans = 2^(iSemit/12)         ; transposicion en bien temperada 
  iTabla = 100+iOct        ; establece la tabla a leer = la octava
  iPan = (p5-6)/3

	ar1 loscil iAmp, iTrans, iTabla, 1
	
	kres madsr 0.01, 0, 1, 3
	
	ar2 = ar1*kres
	
	aL, aR pan2 ar2, iPan    

         outs   aL, aR
endin

</CsInstruments>
<CsScore>

; "Your Song" (Elton John, 1970)

t 0 62 6 62 8 30  ; tempo 62 hasta ti=6+1, baja desde 62 en 6+1 hasta 30 en 8+1 ; (empezamos en 0 por lo que el 3+1 en Csound es 3)

f 102 0 0 1 "piano_do2.wav" 0 0 0
f 103 0 0 1 "piano_do3.wav" 0 0 0
f 104 0 0 1 "piano_do4.wav" 0 0 0
f 105 0 0 1 "piano_do5.wav" 0 0 0

;     p1      p2    p3      p4      p5  
;  Instrum. Inicio Dur. Amp(dBFS) Altura
;========================================
i "sampler"  0.00  0.50   -13.9    9.02
i     .      0.00  0.50   -19.6    8.09
i     .      0.00  0.50   -13.5    8.06
i     .      0.50  0.25   -14.7    8.06
i     .      0.00  1.00   -17.3    8.02
i     .      0.00  1.00   -17.3    7.09
i     .      0.00  1.00   -17.3    6.02
i     .      0.00  1.00   -17.3    7.02
i     .      0.75  0.50   -13.3    8.09
i     .      1.00  0.50   -17.3    7.02
i     .      1.25  0.25   -10.0    9.06
i     .      1.50  0.50   -17.3    9.02
i     .      1.75  0.25   -17.3    7.02

i "sampler"  2.00  0.50   -11.7    9.07
i     .      2.50  0.25   -14.5    9.02
i     .      2.00  1.00   -17.3    7.02
i     .      2.00  1.00   -17.3    6.02
i     .      2.00  1.00   -17.3    8.02
i     .      2.00  1.00   -17.3    7.11
i     .      2.75  0.50   -17.3    8.11
i     .      3.00  0.50   -17.3    7.02
i     .      3.25  0.25   -12.3    9.07
i     .      3.50  0.50   -17.3    9.02
i     .      3.75  0.25   -17.3    7.02

i "sampler"  4.00  0.25   -12.9    8.11
i     .      4.25  0.25   -10.6    9.01
i     .      4.50  0.25   -10.6    8.09
i     .      4.00  1.00   -17.3    7.02
i     .      4.00  1.00   -17.3    6.02
i     .      4.00  1.00   -17.3    8.01
i     .      4.00  1.00   -17.3    7.09
i     .      4.75  0.50   -09.2    9.04
i     .      5.00  0.50   -17.3    7.02
i     .      5.25  0.25   -11.0    9.01
i     .      5.50  0.50   -17.3    8.09
i     .      5.75  0.25   -17.3    7.02

i "sampler"  6.00  0.25   -12.1    8.07
i     .      6.25  0.25   -14.9    8.02
i     .      6.00  0.75   -17.3    7.11
i     .      6.00  1.00   -17.3    7.07 
i     .      6.00  1.00   -17.3    7.02
i     .      6.00  1.00   -17.3    6.02
i     .      6.50  0.50   -17.3    7.11
i     .      6.75  0.50   -11.3    8.11
i     .      7.00  0.50   -17.3    7.02
i     .      7.25  0.25   -12.1    8.07
i     .      7.50  0.50   -17.3    7.11
i     .      7.75  0.25   -17.3    7.02

i "sampler"  8.00  1.00   -18.0    6.02
i     .      8.00  1.00   -20.0    7.02
i     .      8.10  1.00   -21.0    7.09
i     .      8.25  1.00   -23.0    9.06
i     .      8.15  1.00   -21.0    8.02

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
