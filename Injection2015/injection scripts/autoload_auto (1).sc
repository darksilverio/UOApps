# It has methods:            
#     UO.Print("string")  - print message to the client window.
#     UO.Exec("command")  - execute a command. For the list of
#                           commands consult documentation.
#     UO.Count("type",["color"]) - returns count of items of type
#     UO.Say("something") - make you character say something.
#     UO.Press(KeyCode[,Count[,Delay]]) - Simulate keypress.
#          KeyCode    - Virtual key code.
#          Count      - Optional. Number of keypresses.
#          Delay      - Time in msec to wait between keypresses.
#     UO.LClick(X,Y)      - Simulate left button click.
#     UO.RClick(X,Y)      - Simulate right button click.
#     UO.LDblClick(X,Y)   - Simulate left button double click.
#     UO.RDblClick(X,Y)   - Simulate right button double click.
#     UO.Drag(X1,Y1, X2,Y2 [,amount])   - drag something.
# If you don't specify amount the whole stock is dragged.
# You can use "Insert key code" button to get virtual key code.
# And use "Pick coord" to find mouse coordinates on screen.
# Don't forget to call function Wait(time in msec) after
# using skill/spell to wait until it finishes!
# List of read-only properties:
#     UO.Life, UO.Mana, UO.Stamina, UO.STR, UO.INT, UO.DEX,
#     UO.Weight, UO.Armor, UO.Gold, UO.BM, UO.BP, UO.GA, UO.GS,
#     UO.MR, UO.NS, UO.SA, UO.SS, UO.VA, UO.EN, UO.WH, UO.FD,
#     UO.BR, UO.H, UO.C, UO.M, UO.L, UO.B, UO.AR, UO.BT
# Save script as autoload.scp to load automatically every start.


sub main()
   UO.Print("Script Carregado de PVP...")
   
end sub

sub Tracking()
   while not uo.hidden()
      UO.CharPrint('self','0x002b','Tracking!!!')
      uo.UseSkill('Tracking') 
      uo.WaitMenu('Tracking','Monsters','Tracking','Guardian Knight')
      wait(3500)
   wend
end sub 

sub autostart()
   uo.exec('exec autoheal')
   uo.exec('exec sairpoison')
end sub


sub meditar()
   UO.CharPrint('self','0x002b','Meditando!!!')
   uo.warmode(0)
   uo.useskill("Meditation")
end sub

sub ress()
   var i
   Dim a[2]
   a[1] = '0x0192'
   a[2] = '0x0193'
   UO.Set('finddistance','3')
   For i=1 to 2
      uo.findtype(a[i],'-1','ground')
      if uo.findcount() then
         uo.waittargetobject('finditem')
         if uo.count('0x0E21')>79 then
            uo.usetype('0x0E21')
         else
            uo.cast('Resurrection')
         endif
         return
      endif
   Next
end sub


sub esconder()
   
   UO.CharPrint('self','0x002b','Hiding!!!')
   uo.exec('terminate autoheal')
   uo.exec('terminate sairpf')
   uo.exec('terminate sairpoison')
   esperaatraso() 
   uo.warmode(0)
   uo.useskill("Hiding")
   wait(2200)   
   UO.CharPrint('self','0x002b','Invis!!!') 
   while not uo.hidden()
      wait(100)
   wend
   uo.press(20)
   esperaatraso() 
   uo.useskill("Stealth")
   esperaatraso()   
   while uo.hidden()
      Wait(500)
      uo.useskill("Stealth")
   wend
   uo.press(20)
   esperaatraso() 
   uo.exec('exec autoheal')
   uo.exec('exec sairpf')
   uo.exec('exec sairpoison')
end sub   



sub abrircorpo()
   var loop
   DIM BoneCorpse[10]
   BoneCorpse[0]='0x2006' ; type osso
   BoneCorpse[1]='0x0ECA' ; type osso
   BoneCorpse[2]='0x0ECB' ; type osso
   BoneCorpse[3]='0x0ECC' ; type osso
   BoneCorpse[4]='0x0ECD' ; type osso
   BoneCorpse[5]='0x0ECE' ; type osso
   BoneCorpse[6]='0x0ECF' ; type osso
   BoneCorpse[7]='0x0ED0' ; type osso
   BoneCorpse[8]='0x0ED1' ; type osso
   BoneCorpse[9]='0x0ED2' ; type osso
   For loop=0 to 9
      UO.FindType(BoneCorpse[loop],'-1','ground')
      If UO.FindCount()>0 Then
         UO.UseObject('finditem') 
         Wait(200)
      End If
   Next
end sub

Sub EsperaAtraso()
   var ping=0
   ApagaDoJournal('backpack')
   UO.Click('backpack')
   Repeat
      Wait(1)
      ping=ping+1
   Until UO.InJournal('backpack')
   return ping
End Sub   

Sub ApagaDoJournal(t)
   While UO.InJournal(t)
      UO.SetJournalLine(UO.InJournal(t)-1,'')
      Wait(10)
   WEnd
End Sub

sub CortarCorpo()  
   UO.Set('finddistance',3)
   uo.exec('exec abrircorpo')
   UO.FindType('0x2006','-1','ground')
   If UO.FindCount() > 0 Then
      var target=UO.GetSerial('finditem')
      ;UO.Ignore('finditem')
      UO.WaitTargetobject('0x2006')
      UO.UseObject('arma')
      EsperaAtraso()
      if target <> '0x00000000' then
         UO.WaitTargetobject(target)
         UO.UseObject('arma')
         EsperaAtraso()
         uo.exec('exec abrircorpo')
         UO.CharPrint('self','0x0048','Corpo Cortado!')
         uo.exec('disarm')
         ;UO.IgnoreReset()
         uo.exec('terminate CortarCorpoRandom')
      end if
   else
      UO.CharPrint('self','0x0099','Nenhum Corpo Encontrado!')
      uo.exec('disarm')
      ;UO.IgnoreReset()
      uo.exec('terminate CortarCorpoRandom')
   end if   
end sub



# -----------------------------------

sub cure()
   uo.waittargetself()
   uo.cast('Cure')
end sub

sub strr()
   uo.waittargetself()
   uo.cast('Strength')
end sub

sub aglt()
   uo.waittargetself()
   uo.cast('Agility')
end sub

sub ra()
   uo.waittargetself()
   uo.cast('Reactive Armor')
end sub

sub prot()
   uo.waittargetself()
   uo.cast('Protection')
end sub

#--------------------
sub refresh()
   var maxstam = UO.dex
   if uo.stamina < uo.dex then
      UO.CharPrint('self',0x0022, "Total Refresh")
      uo.usetype("0x0F0E","0x0022")
   end if
   if uo.stamina >= uo.dex then
      UO.CharPrint('self',0x0022, "Stamina Full")
   end if
end sub

# ------------------------------------

sub life()
   uo.usetype("0x0F82","0x0026")    
end sub

sub refil()
   uo.usetype("0x0F82","0x017F")    
end sub

# ------------------------------------

sub invis()
   uo.usetype("0x0F0E","0x0001")
end sub

sub curepot()
   if not uo.poisoned('self') then 
      UO.CharPrint('self',0x008F, "Sem Poison")
   else
      uo.DeleteJournal()
      If UO.ObjAtLayer('Robe') Then
         UO.AddObject('Bless',UO.ObjAtLayer('Robe'))
      End If
      If UO.findtype("0x1F03","backpack") > 0 Then
         UO.AddObject('Cure','finditem')
      End If
      UO.UseObject('Cure')
      wait(200)
      UO.UseObject('Bless')
      wait(200)
      if not uo.poisoned('self') then 
         UO.CharPrint('self',0x008F, "Cure Robe")
      end if
      if uo.poisoned('self') then 
         UO.CharPrint('self',0x008F, "Greater Cure")
         uo.usetype("0x0F0E","0x008F")
      end if
   end if
end sub

sub sairpoison()
   while TRUE
      if uo.poisoned('self') then
         uo.DeleteJournal()
         If UO.ObjAtLayer('Robe') Then
            UO.AddObject('Bless',UO.ObjAtLayer('Robe'))
         End If
         If UO.findtype("0x0F03","backpack") > 0 Then
            UO.AddObject('Cure','finditem')
         End If
         UO.UseObject('Cure')
         wait(200)
         UO.UseObject('Bless')
         wait(200)
         if not uo.poisoned('self') then 
            UO.CharPrint('self',0x008F, "Cure Robe")
         end if
         if uo.poisoned('self') then 
            UO.CharPrint('self',0x008F, "Greater Cure")
            uo.usetype("0x0F0E","0x008F")
         end if
      endif
      wait(200)
   wend
end sub

# ------------------------------------

sub mana()
   uo.usetype("0x0F82","0x0532")
end sub



# ------------------------------------
sub band()
   uo.usetype('0x141B')
   uo.waittargetself()
   uo.usetype('0x0E21')
endsub

# ------------------------------------
sub antiparalize()
   uo.waittargetself()
   uo.cast('Magic Arrow')
endsub


#------------------


Sub fs() # Kal Vas Flam
   If UO.Count('0x1F5F') Then
      UO.UseType('0x1F5F')
   Else
      UO.Cast('Flame Strike','laststatus')
   End If
end sub

# ------------------------------------
Sub eb() # Corp Por
   if UO.COUNT('0x01F5F') then
      UO.WaitTargetObject('laststatus')
      uo.usetype("0x1F5F")
   else
      uo.cast('Lightning','laststatus')
   endif
end sub

Sub poison() # poison
   uo.cast('Poison','laststatus')
end sub

Sub manadrain() # poison
   uo.cast('Mana Drain','laststatus')
end sub

Sub ma() # MA
   uo.cast('Magic Arrow','laststatus')
end sub

Sub clumsy() # MA
   uo.cast('Clumsy','laststatus')
end sub

Sub mvampire() # MA
   uo.cast('Mana Vampire','laststatus')
end sub

Sub light() # lightning
   uo.cast('Lightning','laststatus')
end sub

Sub paralyze() # Kal Vas Flam
   uo.cast('Paralyze','laststatus')
end sub

Sub wk() # Weaken
   uo.cast('Weaken','laststatus')
end sub

Sub pf11() # PF
   uo.cast('Paralyze Field')
end sub

Sub walls() 
   uo.cast('Wall of Stone')
end sub

Sub mreflect() 
   uo.cast('Magic Reflection','self')
end sub

Sub ghm()
   uo.cast('Greater Heal','self')
end sub

Sub ef()  
   uo.cast('Energy Field')
end sub

Sub dispel() 
   uo.cast('Dispel')
end sub
# ------------------------------------

sub tame()
   uo.print('Selecione o animal') 
   uo.exec('addobject TOT') 
   while uo.targeting() 
      wait(100) 
   wend 
   uo.warmode(0)
   uo.deletejournal()
   var continuar=true
   while not uo.dead() && continuar == true
      
      uo.deletejournal('Voce falhou ao tentar domar a criatura|linha de visao|novo mestre|too far')
      uo.usetype('0x0EB2')
      uo.waittargetobject('TOT')
      repeat
         wait(100)
         
      until uo.injournal('Voce falhou ao tentar domar a criatura|linha de visao|novo mestre|too far')
      
      if uo.injournal('novo mestre') then
         continuar =false
         UO.CharPrint('self',0x0099, "Animal Tamado")
         UO.WaitTargetObject('TOT')
         UO.usetype("0x0F0E","0x0076")
         uo.exec('terminate tame')       
         
         wait(100)
      endif
      
   wend
endsub

sub lockpick()
   uo.print('Selecione o bau') 
   uo.exec('addobject TOT') 
   while uo.targeting() 
      wait(100) 
   wend 
   uo.warmode(0)
   uo.deletejournal()
   var continuar=true
   while not uo.dead() && continuar == true
      
      uo.deletejournal('unable to pick|You unlock the container.|cannot unlock')
      uo.usetype('0x14FB')
      uo.waittargetobject('TOT')
      repeat
         wait(100)
         
      until uo.injournal('unable to pick|You unlock the container.|cannot unlock')
      
      if uo.injournal('You unlock the container.|cannot unlock') then
         continuar =false
         UO.CharPrint('self',0x0099, "BAU ABERTO")
         
         uo.exec('terminate lockpick')       
         
      endif
      
   wend
endsub

sub forensics()
   uo.print('Selecione o corpo') 
   uo.exec('addobject TOT') 
   while uo.targeting() 
      wait(100) 
   wend 
   uo.warmode(0)
   uo.deletejournal()
   var continuar=true
   while not uo.dead() && continuar == true
      
      uo.deletejournal('unable to pick|You unlock the container.|cannot unlock')
      uo.useskill('Forensic Evaluation')
      uo.waittargetobject('TOT')
      
      wait(1300)
      
   wend
endsub
# ------------------------------------

sub vestir()
   uo.usetype('0x1415');peito plate
   uo.usetype('0x1416');peito plate
   uo.usetype("0x1411");perna
   uo.usetype("0x141A");perna
   uo.usetype("0x1410");ombro
   uo.usetype("0x1417");ombro
   uo.usetype("0x1414");luva
   uo.usetype("0x1418");luva
   uo.usetype("0x1413");gorget
   uo.usetype("0x1412");capacete
   uo.usetype("0x153B");half
   uo.usetype("0x170F");sapato
   uo.usetype("0x1541");body ash
   uo.usetype("0x108A");anel
   uo.usetype("0x204E");rob
   uo.waittargetself()
   uo.usetype('0x0E21')	
   
end sub

sub armarr()
   if uo.count('0x1400') then
      uo.waittargetself()
      uo.usetype('0x1400')
      uo.exec("warmode 1") 
      uo.attack('laststatus') 
      if uo.count('0x1B76') then
         uo.usetype('0x1B76')
      end if  
   else
      if uo.count('0x1404') then
         uo.waittargetself()
         uo.usetype('0x1404')
         uo.exec("warmode 1") 
         uo.attack('laststatus') 
      else
         uo.waittargetself()
         uo.usetype('0x0F48')
         uo.exec("warmode 1") 
         uo.attack('laststatus')
      end if
   end if      
end sub



sub arcoo()   
   uo.usetype('0x13B1')	    	
   uo.exec("warmode 1")
   uo.attack('laststatus')   
end sub


#-----------
sub horsa() 
   If UO.ObjAtLayer('Horse') Then  
      UO.useobject('self')  
      wait(100)
      UO.MSG('all stop') 
   Else    
      UO.MSG('all come') 
      While (UO.Getdistance('Horse')) > 3 
         wait(200) 
      Wend  
      UO.Useobject('horse')  
   Endif 
end sub

sub zoz() 
   If UO.ObjAtLayer('Horse') Then  
      UO.useobject('self')  
      wait(100)
      UO.MSG('all stop') 
      wait(50) 
      UO.WaitTargetObject('laststatus') 
      UO.MSG('all kill') 
   Else    
      UO.MSG('all come') 
      While (UO.Getdistance('Horse')) > 3 
         wait(200) 
      Wend  
      UO.Useobject('horse')  
   Endif 
end sub

sub tirar()
   uo.exec ('disarm')
end sub

#---------------------------------
sub Tele5() 
   uo.waittargettile("400",str(uo.getx("self")-1),str(uo.gety("self")-1),str(uo.getz("self")-9)) 
   uo.cast("Teleport") 
end sub
#---------------------------------
sub Tele3() 
   uo.waittargettile("400",str(uo.getx("self")+1),str(uo.gety("self")+1),str(uo.getz("self")-9)) 
   uo.cast("Teleport") 
end sub 
#---------------------------------
sub stopanti()
   uo.print("ANTI DESATIVADO")
   uo.exec("terminate all")
end sub
#-----------
sub exp()
   uo.waittargettype("0x0F02, 0x0000")
   uo.cast('Magic Arrow')
   
end sub

#-----
sub dgate()
   uo.cast('Dispel')
   uo.waittargetground(0x0F6C) 
   wait(200)
   uo.disarm()
end sub
#-------------------
sub bar()                   
   If UO.ObjAtLayer('barco') Then  
   Else    
      
      While (UO.Getdistance('barco')) > 10 
         wait(200) 
      Wend  
      uo.exec("warmode 0") 
      UO.Useobject('barco') 
      wait(100)
      uo.exec("warmode 0") 
      UO.Useobject('barco') 
      wait(100) 
      uo.exec("warmode 0") 
      UO.Useobject('barco') 
      wait(100) 
      uo.exec ('msg Pulo do Gato Preto!!!')
   Endif 
end sub
#--------------


sub lag()
   var a=0
   uo.deletejournal()
   uo.click('backpack')
   repeat
      a=a+1
      wait(1)
      
   until uo.injournal('backpack')
   
   UO.CharPrint('self',0x0034,'Ping: '+ STR(A*2) + ' ms')
end sub



# ------------------------------------
sub autoheal()
   ;UO.CharPrint('self',0x0034,'Bands ON!')
   while not uo.dead()
      if uo.life < uo.str then 
         UO.bandageself()
         wait(5500) 
      endif 
      wait(200); 
   wend 
end sub

#----------------
sub detec()
   UO.CharPrint('self','0x002b','Detect Hidden!!!')
   uo.WarMode(0)
   UO.UseSkill("Detect")
end sub

#-----------
sub pf()  ; pf em baixo de vc
   Uo.waittargettile("400",str(Uo.getx("self")),str(Uo.gety("self")),str(Uo.getz("self"))) 
   Uo.cast("Paralyze Field")
end sub

sub pf2(); PF NO TARGET DO OPONENTE 
   UO.addobject('lt', 'laststatus')
   Uo.waittargettile("400",str(Uo.getx("lt")),str(Uo.gety("lt")),str(Uo.getz("lt")))
   uo.cast('Paralyze Field')
end sub

sub wall2()  ; soltar wall em \ atraz do kra
   UO.addobject('lt', 'laststatus') 
   uo.waittargettile("400",str(uo.getx("lt")),str(uo.gety("lt")-1),str(uo.getz("lt"))) 
   uo.cast("Wall of Stone") 
end sub 


sub ffield()  ; ff em baixo de vc
   Uo.waittargettile("400",str(Uo.getx("self")),str(Uo.gety("self")),str(Uo.getz("self"))) 
   Uo.cast("Fire Field")
end sub
#------------
sub wall()  ; wall em baixo de vc
   Uo.waittargettile("400",str(Uo.getx("self")),str(Uo.gety("self")),str(Uo.getz("self"))) 
   Uo.cast("Wall of Stone")
end sub


sub opendoor()
   var n
   uo.set('finddistance','2')
   DIM P1[105]
   P1[0]='0x0675'
   P1[1]='0x0677'
   P1[2]='0x0679'
   P1[3]='0x067B'
   P1[4]='0x067D'
   P1[5]='0x067F'
   P1[6]='0x0681'
   P1[7]='0x0683'
   P1[8]='0x0685'
   P1[9]='0x0687'
   P1[10]='0x0689'
   P1[11]='0x068B'
   P1[12]='0x068D'
   P1[13]='0x068F'
   P1[14]='0x0691'
   P1[15]='0x0693'
   P1[16]='0x0695'
   P1[17]='0x0697'
   P1[18]='0x0699'
   P1[19]='0x069B'
   P1[20]='0x069D'
   P1[21]='0x069F'
   P1[22]='0x06A1'
   P1[23]='0x06A3'
   P1[24]='0x06A5'
   P1[25]='0x06A7'
   P1[26]='0x06A9'
   P1[27]='0x06AB'
   P1[28]='0x06AD'
   P1[29]='0x06AF'
   P1[30]='0x06B1'
   P1[31]='0x06B3'
   P1[32]='0x06B5'
   P1[33]='0x06B7'
   P1[34]='0x06B9'
   P1[35]='0x06BB'
   P1[36]='0x06BD'
   P1[37]='0x06BF'
   P1[38]='0x06C1'
   P1[39]='0x06C3'
   P1[40]='0x06C5'
   P1[41]='0x06C7'
   P1[42]='0x06C9'
   P1[43]='0x06CB'
   P1[44]='0x06CD'
   P1[45]='0x06CF'
   P1[46]='0x06D1'
   P1[47]='0x06D3'
   P1[48]='0x06D5'
   P1[49]='0x06D7'
   P1[50]='0x06D9'
   P1[51]='0x06DB'
   P1[52]='0x06DD'
   P1[53]='0x06DF'
   P1[54]='0x06E1'
   P1[55]='0x06E3'
   P1[56]='0x06E5'
   P1[57]='0x06E7'
   P1[58]='0x06E9'
   P1[59]='0x06EB'
   P1[60]='0x06ED'
   P1[61]='0x06EF'
   P1[62]='0x06F1'
   P1[63]='0x06F3'
   P1[64]='0x06F5'
   ; 824-833 ;
   P1[65]='0x0824'
   P1[66]='0x0826'
   P1[67]='0x0828'
   P1[68]='0x082A'
   P1[69]='0x082C'
   P1[70]='0x082E'
   P1[71]='0x0830'
   P1[72]='0x0832'
   ; 839-848 ;
   P1[73]='0x0839'
   P1[74]='0x083B'
   P1[75]='0x083D'
   P1[76]='0x083F'
   P1[77]='0x0841'
   P1[78]='0x0843'
   P1[79]='0x0845'
   P1[80]='0x0847'
   ; 84C-85B ;
   P1[81]='0x084C'
   P1[82]='0x084E'
   P1[83]='0x0850'
   P1[84]='0x0852'
   P1[85]='0x0854'
   P1[86]='0x0856'
   P1[87]='0x0858'
   P1[88]='0x085A'
   ; 866-875 ;
   P1[89]='0x0866'
   P1[90]='0x0868'
   P1[91]='0x086A'
   P1[92]='0x086C'
   P1[93]='0x086E'
   P1[94]='0x0870'
   P1[95]='0x0872'
   P1[96]='0x0874'
   ; 1FED-1FFC ;
   P1[97]='0x1FED'
   P1[98]='0x1FEF'
   P1[99]='0x1FF1'
   P1[100]='0x1FF3'
   P1[101]='0x1FF5'
   P1[102]='0x1FF7'
   P1[103]='0x1FF9'
   P1[104]='0x1FFB'
   ; Portas Secretas 1 ;
   DIM PS1[48]
   ; E8-F7 ;
   PS1[0]='0x00E8'
   PS1[1]='0x00EA'
   PS1[2]='0x00EC'
   PS1[3]='0x00EE'
   PS1[4]='0x00F0'
   PS1[5]='0x00F2'
   PS1[6]='0x00F4'
   PS1[7]='0x00F6'
   ; 314-363 ;
   PS1[8]='0x0314'
   PS1[9]='0x0316'
   PS1[10]='0x0318'
   PS1[11]='0x031A'
   PS1[12]='0x031C'
   PS1[13]='0x031E'
   PS1[14]='0x0320'
   PS1[15]='0x0322'
   PS1[16]='0x0324'
   PS1[17]='0x0326'
   PS1[18]='0x0328'
   PS1[19]='0x032A'
   PS1[20]='0x032C'
   PS1[21]='0x032E'
   PS1[22]='0x0330'
   PS1[23]='0x0332'
   PS1[24]='0x0334'
   PS1[25]='0x0336'
   PS1[26]='0x0338'
   PS1[27]='0x033A'
   PS1[28]='0x033C'
   PS1[29]='0x033E'
   PS1[30]='0x0340'
   PS1[31]='0x0342'
   PS1[32]='0x0344'
   PS1[33]='0x0346'
   PS1[34]='0x0348'
   PS1[35]='0x034A'
   PS1[36]='0x034C'
   PS1[37]='0x034E'
   PS1[38]='0x0350'
   PS1[39]='0x0352'
   PS1[40]='0x0354'
   PS1[41]='0x0356'
   PS1[42]='0x0358'
   PS1[43]='0x035A'
   PS1[44]='0x035C'
   PS1[45]='0x035E'
   PS1[46]='0x0360'
   PS1[47]='0x0362'
   For n=0 to 104
      UO.FindType(P1[n],"-1",'ground')
      if UO.FindCount()>0 then
         UO.UseObject('finditem')
         Wait(28)
      end if
   Next
   For n=0 to 47
      UO.FindType(PS1[n],"-1",'ground')
      if UO.FindCount()>0 then
         UO.UseObject('finditem')
         Wait(28)
      end if
   Next
   UO.SetGlobal('globalPortas','1')
   uo.set('finddistance','15')
   UO.CharPrint('self',0x0026,'Portas Abertas!')
End Sub

Sub closedoor()
   var n
   UO.Set('finddistance','2')
   ; Portas 2 ;
   DIM P2[105]
   ; 675-6F6 ;
   P2[0]='0x0676'
   P2[1]='0x0678'
   P2[2]='0x067A'
   P2[3]='0x067C'
   P2[4]='0x067E'
   P2[5]='0x0680'
   P2[6]='0x0682'
   P2[7]='0x0684'
   P2[8]='0x0686'
   P2[9]='0x0688'
   P2[10]='0x068A'
   P2[11]='0x068C'
   P2[12]='0x068E'
   P2[13]='0x0690'
   P2[14]='0x0692'
   P2[15]='0x0694'
   P2[16]='0x0696'
   P2[17]='0x0698'
   P2[18]='0x069A'
   P2[19]='0x069C'
   P2[20]='0x069E'
   P2[21]='0x06A0'
   P2[22]='0x06A2'
   P2[23]='0x06A4'
   P2[24]='0x06A6'
   P2[25]='0x06A8'
   P2[26]='0x06AA'
   P2[27]='0x06AC'
   P2[28]='0x06AE'
   P2[29]='0x06B0'
   P2[30]='0x06B2'
   P2[31]='0x06B4'
   P2[32]='0x06B6'
   P2[33]='0x06B8'
   P2[34]='0x06BA'
   P2[35]='0x06BC'
   P2[36]='0x06BE'
   P2[37]='0x06C0'
   P2[38]='0x06C2'
   P2[39]='0x06C4'
   P2[40]='0x06C6'
   P2[41]='0x06C8'
   P2[42]='0x06CA'
   P2[43]='0x06CC'
   P2[44]='0x06CE'
   P2[45]='0x06D0'
   P2[46]='0x06D2'
   P2[47]='0x06D4'
   P2[48]='0x06D6'
   P2[49]='0x06D8'
   P2[50]='0x06DA'
   P2[51]='0x06DC'
   P2[52]='0x06DE'
   P2[53]='0x06E0'
   P2[54]='0x06E2'
   P2[55]='0x06E4'
   P2[56]='0x06E6'
   P2[57]='0x06E8'
   P2[58]='0x06EA'
   P2[59]='0x06EC'
   P2[60]='0x06EE'
   P2[61]='0x06F0'
   P2[62]='0x06F2'
   P2[63]='0x06F4'
   P2[64]='0x06F6'
   ; 824-833 ;
   P2[65]='0x0825'
   P2[66]='0x0827'
   P2[67]='0x0829'
   P2[68]='0x082A'
   P2[69]='0x082C'
   P2[70]='0x082E'
   P2[71]='0x0831'
   P2[72]='0x0833'
   ; 839-848 ;
   P2[73]='0x083A'
   P2[74]='0x083C'
   P2[75]='0x083E'
   P2[76]='0x0840'
   P2[77]='0x0842'
   P2[78]='0x0844'
   P2[79]='0x0846'
   P2[80]='0x0848'
   ; 84C-85B ;
   P2[81]='0x084D'
   P2[82]='0x084F'
   P2[83]='0x0851'
   P2[84]='0x0853'
   P2[85]='0x0855'
   P2[86]='0x0857'
   P2[87]='0x0859'
   P2[88]='0x085B'
   ; 866-875 ;
   P2[89]='0x0867'
   P2[90]='0x0869'
   P2[91]='0x086B'
   P2[92]='0x086D'
   P2[93]='0x086F'
   P2[94]='0x0871'
   P2[95]='0x0873'
   P2[96]='0x0875'
   ; 1FED-1FFC ;
   P2[97]='0x1FEE'
   P2[98]='0x1FF0'
   P2[99]='0x1FF2'
   P2[100]='0x1FF4'
   P2[101]='0x1FF6'
   P2[102]='0x1FF8'
   P2[103]='0x1FFA'
   P2[104]='0x1FFC'
   ; Portas Secretas 2 ;
   DIM PS2[48]
   ; E8-F7 ;
   PS2[0]='0x00E9'
   PS2[1]='0x00EB'
   PS2[2]='0x00ED'
   PS2[3]='0x00EF'
   PS2[4]='0x00F1'
   PS2[5]='0x00F3'
   PS2[6]='0x00F5'
   PS2[7]='0x00F7'
   ; 314-363 ;
   PS2[8]='0x0315'
   PS2[9]='0x0317'
   PS2[10]='0x0319'
   PS2[11]='0x031B'
   PS2[12]='0x031D'
   PS2[13]='0x031F'
   PS2[14]='0x0321'
   PS2[15]='0x0323'
   PS2[16]='0x0325'
   PS2[17]='0x0327'
   PS2[18]='0x0329'
   PS2[19]='0x032B'
   PS2[20]='0x032D'
   PS2[21]='0x032F'
   PS2[22]='0x0331'
   PS2[23]='0x0333'
   PS2[24]='0x0335'
   PS2[25]='0x0337'
   PS2[26]='0x0339'
   PS2[27]='0x033B'
   PS2[28]='0x033D'
   PS2[29]='0x033F'
   PS2[30]='0x0341'
   PS2[31]='0x0343'
   PS2[32]='0x0345'
   PS2[33]='0x0347'
   PS2[34]='0x0349'
   PS2[35]='0x034B'
   PS2[36]='0x034D'
   PS2[37]='0x034F'
   PS2[38]='0x0351'
   PS2[39]='0x0353'
   PS2[40]='0x0355'
   PS2[41]='0x0357'
   PS2[42]='0x0359'
   PS2[43]='0x035B'
   PS2[44]='0x035D'
   PS2[45]='0x035F'
   PS2[46]='0x0361'
   PS2[47]='0x0363'
   For n=0 to 104
      UO.FindType(P2[n],"-1",'ground')
      if UO.FindCount()>0 then
         UO.UseObject('finditem')
         Wait(28)
      end if
   Next
   For n=0 to 47
      UO.FindType(PS2[n],"-1",'ground')
      if UO.FindCount()>0 then
         UO.UseObject('finditem')
         Wait(28)
      end if
   Next
   UO.SetGlobal('globalPortas','0')
   uo.set('finddistance','15')
   UO.CharPrint('self',0x0026,'Portas Fechadas!')
End Sub

Sub AlternarPortas()
   If UO.GetGlobal('globalPortas')<>'1' Then
      opendoor()
      
   Else
      closedoor()
      
   End If
End Sub




sub LootChao()
   var i,n 
   uo.set('finddistance','3')
   Dim A[32]
   
   A[1] = 0x175D; pano white
   A[2] = 0x175D; pano gray
   A[3] = 0x175D; pano black
   A[4] = 0x14EB ;mapa
   
   A[5] = 0x0EED ;GOLD
   A[6] = -1 ;"Arma Vank"
   A[7] = -1 ;Arma Power
   A[8] = -1 ;Arma Force
   A[9] = -1 ;Arma Might
   A[10] = -1 ;Arma Ruin
   A[11] = -1 ;Arma Force
   A[12] = -1 ;Arma Might
   A[13] = -1 ;Arma Ruin
   
   A[14] = -1 ;Mana
   A[15] = -1 ;Refil
   A[16] = -1 ;Life
   
   A[17] = 0x0e76 ;Bag
   
   A[18] = 0x1C04 ;peito 2
   A[19] = 0x1415 ;peito 1
   A[20] = 0x1411 ;Perna 1
   A[21] = 0x1545 ;BearMask 
   A[22] = 0x0F16 ;Deer Mask
   A[23] = 0x154B ; Magic Mask
   A[24] = 0x141B ;Orc Mask 
   A[25] = 0x1F0B ;Orc Helm 
   A[26] = 0x1086 ;Bracelete Taming
   A[27] = 0x171B ;Chapeu pirata
   A[28] = 0x108A ;Anel
   A[29] = 0x1088 ;Amuleto
   A[30] = 0x0E21 ;Bandage
   A[31] = 0x1F5F ;FS
   A[32] = 0x0F3F ;Arrow 
   
   
   Dim B[32]
   
   B[1] = "Pano White"
   B[2] = "Pano Gray"
   B[3] = "Pano Black"
   B[4] = "Mapa"
   
   B[5] = "Gold"
   B[6] = "Arma Vank"
   B[7] = "Arma Power"
   B[8] = "Arma Force"
   B[9] = "Arma Might"
   B[10] = "Arma Ruin"
   B[11] = "Arma Force"
   B[12] = "Arma Might"
   B[13] = "Arma Ruin"
   
   B[14] = "Manaboost"
   B[15] = "Refiling"
   B[16] = "Lifeboost"
   
   B[17] = "Bag"
   
   B[18] = "Peito"
   B[19] = "Peito"
   B[20] = "Perna"
   B[21] = "Bear Mask"
   B[22] = "Deer Mask"
   B[23] = "Magic Mask"
   B[24] = "Orc Mask" 
   B[25] = "Orc Helm" 
   B[26] = "Bracelete Taming"
   B[27] = "Chapeu pirata"
   B[28] = "Anel"
   B[29] = "Amuleto"
   B[30] = "Bandage"
   B[31] = "Flame Strike"
   B[32] = "Arrow"
   
   Dim C[32]
   
   C[1] = 0x0481  ;"Pano White "
   C[2] = 0x0482 ; Pano Gray
   C[3] = 0x0001  ;" Pano Black"
   C[4] = -1 ;"Mapa"
   
   C[5] = -1 ;"Gold"
   C[6] = 0x0A20 ; "Arma Vank"
   C[7] = 0x0272 ; "Arma Power"
   C[8] = 0x0030 ; "Arma Force"
   C[9] = 0x0123 ; "Arma Might"
   C[10] = 0x0A37  ;"Arma Ruin"
   C[11] = 0x0030  ;"Arma Force"
   C[12] = 0x0123  ;"Arma Might"
   C[13] = 0x0A37  ;"Arma Ruin"
   
   C[14] = 0x0532 ;"Mana"
   C[15] = 0x017F ;"Refil"
   C[16] =  0x0026 ;"Life"
   
   C[17] = -1 ;"Bag"
   
   C[18] = -1 ;"Peito"
   C[19] = -1 ;"Peito"
   C[20] = -1 ;"Perna"
   C[21] = -1  ;"Bear Mask"
   C[22] = -1  ;"Deer Mask"
   C[23] = -1 ;"Magic Mask"
   C[24] = -1 ; Orc Mask  0x141B
   C[25] = -1 ; Orc Helm 0x1F0B
   C[26] = 0x07D1 ;"Bracelete Taming"
   C[27] = -1  ;"Bracelete"
   C[28] = -1  ;"Anel"
   C[29] = -1  ;"Amuleto"
   C[30] = -1  ;"Bandage"
   C[31] = -1  ;"FS"
   C[32] = -1  ;"ARROW"
   
   UO.CharPrint('self',0x0026,'Looting...')
   FOR n=1 TO 32
      uo.findtype(A[n],C[n],'ground') 
      if uo.findcount() > 0 && UO.GetDistance('finditem') < 3 then
         UO.grab(0,"finditem") 
         UO.Set('quiet',0)
         uo.charprint('self',0x0026,"+"+STR(UO.GetQuantity('finditem'))+" "+B[n]) 
         UO.Set('quiet',1)
         ;[Wait((666)+UO.Random(int(500)))
         wait(666)
      end if 
   NEXT
   UO.CharPrint('self',0x002b,'Looting Completo!')
end sub


sub Lootcorpo()
   var i,n 
   
   Dim A[32]
   
   A[1] = 0x175D; pano white
   A[2] = 0x175D; pano gray
   A[3] = 0x175D; pano black
   A[4] = 0x14EB ;mapa
   
   A[5] = 0x0EED ;GOLD
   A[6] = -1 ;"Arma Vank"
   A[7] = -1 ;Arma Power
   A[8] = -1 ;Arma Force
   A[9] = -1 ;Arma Might
   A[10] = -1 ;Arma Ruin
   A[11] = -1 ;Arma Force
   A[12] = -1 ;Arma Might
   A[13] = -1 ;Arma Ruin
   
   A[14] = 0x0F82 ;Mana
   A[15] = 0x0F82 ;Refil
   A[16] = 0x0F82 ;Life
   
   A[17] = 0x0e76 ;Bag
   
   A[18] = 0x1C04 ;peito 2
   A[19] = 0x1415 ;peito 1
   A[20] = 0x1411 ;Perna 1
   A[21] = 0x1545 ;BearMask 
   A[22] = 0x0F16 ;Deer Mask
   A[23] = 0x154B ; Magic Mask
   A[24] = 0x141B ;Orc Mask 
   A[25] = 0x1F0B ;Orc Helm 
   A[26] = 0x1086 ;Bracelete Taming
   A[27] = 0x171B ;Chapeu pirata
   A[28] = 0x108A ;Anel
   A[29] = 0x1088 ;Amuleto
   A[30] = 0x0E21 ;Bandage
   A[31] = 0x1F5F ;FS
   A[32] = 0x0F3F ;Arrow 
   
   
   Dim B[32]
   
   B[1] = "Pano White"
   B[2] = "Pano Gray"
   B[3] = "Pano Black"
   B[4] = "Mapa"
   
   B[5] = "Gold"
   B[6] = "Arma Vank"
   B[7] = "Arma Power"
   B[8] = "Arma Force"
   B[9] = "Arma Might"
   B[10] = "Arma Ruin"
   B[11] = "Arma Force"
   B[12] = "Arma Might"
   B[13] = "Arma Ruin"
   
   B[14] = "Manaboost"
   B[15] = "Refiling"
   B[16] = "Lifeboost"
   
   B[17] = "Bag"
   
   B[18] = "Peito"
   B[19] = "Peito"
   B[20] = "Perna"
   B[21] = "Bear Mask"
   B[22] = "Deer Mask"
   B[23] = "Magic Mask"
   B[24] = "Orc Mask" 
   B[25] = "Orc Helm" 
   B[26] = "Bracelete Taming"
   B[27] = "Chapeu pirata"
   B[28] = "Anel"
   B[29] = "Amuleto"
   B[30] = "Bandage"
   B[31] = "Flame Strike"
   B[32] = "Arrow"
   
   Dim C[32]
   
   C[1] = 0x0481  ;"Pano White "
   C[2] = 0x0482 ; Pano Gray
   C[3] = 0x0001  ;" Pano Black"
   C[4] = -1 ;"Mapa"
   
   C[5] = -1 ;"Gold"
   C[6] = 0x0A20 ; "Arma Vank"
   C[7] = 0x0272 ; "Arma Power"
   C[8] = 0x0030 ; "Arma Force"
   C[9] = 0x0123 ; "Arma Might"
   C[10] = 0x0A37  ;"Arma Ruin"
   C[11] = 0x0030  ;"Arma Force"
   C[12] = 0x0123  ;"Arma Might"
   C[13] = 0x0A37  ;"Arma Ruin"
   
   C[14] = 0x0532 ;"Mana"
   C[15] = 0x017F ;"Refil"
   C[16] =  0x0026 ;"Life"
   
   C[17] = -1 ;"Bag"
   
   C[18] = -1 ;"Peito"
   C[19] = -1 ;"Peito"
   C[20] = -1 ;"Perna"
   C[21] = -1  ;"Bear Mask"
   C[22] = -1  ;"Deer Mask"
   C[23] = -1 ;"Magic Mask"
   C[24] = -1 ; Orc Mask  0x141B
   C[25] = -1 ; Orc Helm 0x1F0B
   C[26] = 0x07D1 ;"Bracelete Taming"
   C[27] = 0x0455  ;"Chapeu Pirata"
   C[28] = -1  ;"Anel"
   C[29] = -1  ;"Amuleto"
   C[30] = -1  ;"Bandage"
   C[31] = -1  ;"FS"
   C[32] = -1  ;"ARROW"
   
   UO.CharPrint('self',0x0026,'Looting...')
   FOR n=1 TO 32
      uo.findtype(A[n],C[n],'lastcontainer') 
      if uo.findcount() > 0 then
         UO.grab(0,"finditem") 
         UO.Set('quiet',0)
         uo.charprint('self',0x0026,"+"+STR(UO.GetQuantity('finditem'))+" "+B[n]) 
         UO.Set('quiet',1)
         Wait(1900)
      end if 
   NEXT
   UO.CharPrint('self',0x002b,'Looting Completo!')
end sub

sub openbank2()
   
   uo.msg('Banker Bank')
   
end sub

sub sairpf()
   UO.deletejournal()
   while TRUE
      if UO.injournal("You are frozen and can not move.") and not UO.injournal(": You are frozen and can not move.") Then
         if UO.COUNT('0x0F02') == 0 then
            uo.waittargetself()
            uo.cast('Dispel')
            wait(2300)
            uo.DeleteJournal("You are frozen and can not move.")
         else 
            uo.waittargettype("0x0F02")
            uo.cast('Magic Arrow')
            wait(1760)
            uo.DeleteJournal("You are frozen and can not move.")
         endif
      endif
      if UO.injournal(": You are frozen and can not move.") Then
         uo.DeleteJournal(": You are frozen and can not move.")
      endif
      wait(200)
   wend
end sub

Sub pcimamantle()
   var x=uo.dex
   var timeout=0
   uo.DeleteJournal()
   If UO.ObjAtLayer('Hat') Then
      UO.AddObject('Hat',UO.ObjAtLayer('Hat'))
   End If
   If UO.ObjAtLayer('Robe') Then
      UO.AddObject('Robe',UO.ObjAtLayer('Robe'))
   End If
   If UO.ObjAtLayer('Pants') Then
      UO.AddObject('Pants',UO.ObjAtLayer('Pants'))
   End If
   If UO.ObjAtLayer('Shirt') Then
      UO.AddObject('Shirt',UO.ObjAtLayer('Shirt'))
   End If
   If UO.ObjAtLayer('Gloves') Then
      UO.AddObject('Gloves',UO.ObjAtLayer('Gloves'))
   End If
   If UO.ObjAtLayer('Arms') Then
      UO.AddObject('Arms',UO.ObjAtLayer('Arms'))
   End If
   If UO.ObjAtLayer('Neck') Then
      UO.AddObject('Neck',UO.ObjAtLayer('Neck'))
   End If    
   if uo.stamina >= x then
      UO.CharPrint('self',0x0022, "Stamina Full")
   end if
   if uo.stamina >= x-10 then
      While UO.ObjAtLayer('Robe') AND UO.GetSerial('Robe')<>'0x00000000'
         UO.Grab(1,'Robe')
      wend
      While UO.ObjAtLayer('Hat') AND UO.GetSerial('Hat')<>'0x00000000'
         UO.Grab(1,'Hat')
      wend
      uo.charprint('self','0x0035','Pode Passar!')
      repeat
         wait(100)
         timeout = timeout + 1
      until uo.InJournal("You shove") or timeout > 14
      uo.useobject('Hat')
      uo.useobject('Robe')
      UO.bandageself()
   end if
   if uo.stamina >= x-20 then
      While UO.ObjAtLayer('Robe') AND UO.GetSerial('Robe')<>'0x00000000'
         UO.Grab(1,'Robe')
      wend
      While UO.ObjAtLayer('Hat') AND UO.GetSerial('Hat')<>'0x00000000'
         UO.Grab(1,'Hat')
      wend
      While UO.ObjAtLayer('Arms') AND UO.GetSerial('Arms')<>'0x00000000'
         UO.Grab(1,'Arms')
      wend
      While UO.ObjAtLayer('Gloves') AND UO.GetSerial('Gloves')<>'0x00000000'
         UO.Grab(1,'Gloves')
      wend
      While UO.ObjAtLayer('Neck') AND UO.GetSerial('Neck')<>'0x00000000'
         UO.Grab(1,'Neck')
      wend
      uo.charprint('self','0x0035','Pode Passar!')
      repeat
         wait(100)
         timeout = timeout + 1
      until uo.InJournal("You shove") or timeout > 14
      uo.useobject('Hat')
      uo.useobject('Robe')
      uo.useobject('Gloves')
      uo.useobject('Arms')
      UO.bandageself()          
   end if
   if uo.stamina >= x-20 then
      While UO.ObjAtLayer('Robe') AND UO.GetSerial('Robe')<>'0x00000000'
         UO.Grab(1,'Robe')
      wend
      While UO.ObjAtLayer('Hat') AND UO.GetSerial('Hat')<>'0x00000000'
         UO.Grab(1,'Hat')
      wend
      While UO.ObjAtLayer('Arms') AND UO.GetSerial('Arms')<>'0x00000000'
         UO.Grab(1,'Arms')
      wend
      While UO.ObjAtLayer('Gloves') AND UO.GetSerial('Gloves')<>'0x00000000'
         UO.Grab(1,'Gloves')
      wend
      While UO.ObjAtLayer('Neck') AND UO.GetSerial('Neck')<>'0x00000000'
         UO.Grab(1,'Neck')
      wend
      While UO.ObjAtLayer('Shirt') AND UO.GetSerial('Shirt')<>'0x00000000'
         UO.Grab(1,'Shirt')
      wend
      While UO.ObjAtLayer('Neck') AND UO.GetSerial('Neck')<>'0x00000000'
         UO.Grab(1,'Neck')
      wend
      uo.charprint('self','0x0035','Pode Passar!')
      repeat
         wait(100)
         timeout = timeout + 1
      until uo.InJournal("You shove") or timeout > 14
      uo.useobject('Hat')
      uo.useobject('Robe')
      uo.useobject('Gloves')
      uo.useobject('Arms')
      uo.useobject('Shirt')
      uo.useobject('Pants')
      UO.bandageself()          
   end if
   if uo.stamina <= x-31 then
      uo.useobject('Hat')
      uo.useobject('Robe')
      uo.useobject('Gloves')
      uo.useobject('Arms')
      uo.useobject('Shirt')
      uo.useobject('Pants')
      UO.bandageself()
      uo.exec('exec refresh')
      wait(50)
      uo.charprint('self','0x0035','Pode Passar!')
   End if
End Sub


sub inimigo()
   uo.addobject("inimigo")
   while uo.targeting()
      wait(100)
   wend
end sub


sub explosion_inimigo()
   uo.waittargetobject('inimigo')
   if uo.count('0x1F5F') == 0 then
      uo.cast('Lightning')
   else
      uo.usetype('0x1F5F')
   endif
end sub


sub potion()
   var maxhp = UO.Str
   var maxmana = uo.INT
   uo.findtype("0x0F82","0x017F")
   if uo.count("0x0F82","0x017F") > 0 then
      If UO.Life <= maxhp And UO.Mana <= maxmana Then
         uo.charprint("self","0x017F","Refiling")
         uo.exec('exec refil')
         uo.exec('terminate potion')
      End If
   end if
   uo.findtype("0x0F82","0x0532")
   if uo.count("0x0F82","0x0532") > 0 then
      If UO.Life >= maxhp And UO.Mana <= maxmana Then
         uo.charprint("self","0x0532","Mana Boost")
         uo.exec('exec mana')
         uo.exec('terminate potion')
      End If
   end if
   uo.findtype("0x0F82","0x0026")
   if uo.count("0x0F82","0x0026")  > 0 then
      If UO.Life <= maxhp And UO.Mana >= maxmana Then
         uo.charprint("self","0x0026","Life Boost")
         uo.exec('exec life')
         uo.exec('terminate potion')
      End If 
   end if
   If UO.Life > maxhp And UO.Mana > maxmana Then
      uo.charprint("self","0x002B","Status Full")
      uo.exec('terminate potion')
   End If   
   
endsub

sub nexttarget()
   var tipo
   var currenttarget = 0x00000000
   var t=0
   var amigoEncontrado=false
   var targetAnterior=0x00000000
   
   DIM amigo[6]
   amigo[0]='ZilD'
   amigo[1]='Estroma'
   amigo[2]='GiantrulezRJ'
   amigo[3]='Wewerine'
   amigo[4]='amnesia'
   amigo[5]='Ovini mOon'
   
   UO.Ignore('self')
   UO.Set("finddistance","35")
   
   uo.press(122)
   EsperaAtraso()
   tipo = UO.GetGraphic(laststatus)
   
   while uo.GetName("laststatus") <> ""
      currenttarget = uo.getserial("laststatus")
      if (targetAnterior == currenttarget) then
         return 0
      end if
      
      if (tipo == "0x0190" or tipo == "0x0191") then
         for t=0 to 5
            if uo.GetName(currenttarget) == amigo[t] then
               uo.ignore(currenttarget)
               ;UO.CharPrint('self',0x0048, "== AMIGO ==")
               amigoEncontrado=true
            end if
         next
         
         if (amigoEncontrado) then
            uo.press(122)
            EsperaAtraso()
            tipo = UO.GetGraphic(laststatus)
            targetAnterior = currenttarget
            amigoEncontrado=false
         else
            UO.AddObject('vitima',"laststatus")
            UO.Set('quiet',0)
            UO.CharPrint('self',0x0034, uo.getname("vitima"))
            targetAnterior = currenttarget
            uo.ignore(currenttarget)
            return 0  
         end if
      end if 
      
      if (tipo <> "0x0190" or tipo <> "0x0191") then
         ;UO.CharPrint('self',0x0048, "== MONSTRO ==")
         uo.press(122)
         EsperaAtraso()
         tipo = UO.GetGraphic(laststatus)
         targetAnterior = currenttarget
      end if
      
      
   wend
   UO.CharPrint('self',0x0099, "== SEM ALVO ==")
   
end sub

sub nexttarget2()
   var tipo
   var currenttarget = 0x00000000
   var t=0
   var amigoEncontrado=false
   var targetAnterior=0x00000000
   
   DIM amigo[6]
   amigo[0]='ZilD'
   amigo[1]='Estroma'
   amigo[2]='GiantrulezRJ'
   amigo[3]='Wewerine'
   amigo[4]='amnesia'
   amigo[5]='Ovini mOon'
   
   UO.Ignore('self')
   UO.Set("finddistance","35")
   
   uo.press(123)
   EsperaAtraso()
   tipo = UO.GetGraphic(laststatus)
   
   while uo.GetName("laststatus") <> ""
      currenttarget = uo.getserial("laststatus")
      if (targetAnterior == currenttarget) then
         return 0
      end if
      
      if (tipo == "0x0190" or tipo == "0x0191") then
         for t=0 to 5
            if uo.GetName(currenttarget) == amigo[t] then
               uo.ignore(currenttarget)
               ;UO.CharPrint('self',0x0048, "== AMIGO ==")
               amigoEncontrado=true
            end if
         next
         
         if (amigoEncontrado) then
            uo.press(123)
            EsperaAtraso()
            tipo = UO.GetGraphic(laststatus)
            targetAnterior = currenttarget
            amigoEncontrado=false
         else
            UO.AddObject('vitima',"laststatus")
            UO.Set('quiet',0)
            UO.CharPrint('self',0x0034, uo.getname("vitima"))
            targetAnterior = currenttarget
            uo.ignore(currenttarget)
            return 0  
         end if
      end if 
      
      if (tipo <> "0x0190" or tipo <> "0x0191") then
         ;UO.CharPrint('self',0x0048, "== MONSTRO ==")
         uo.press(123)
         EsperaAtraso()
         tipo = UO.GetGraphic(laststatus)
         targetAnterior = currenttarget
      end if
      
      
   wend
   UO.CharPrint('self',0x0099, "== SEM ALVO ==")
   
end sub


Sub AllNames()
   UO.Set('quiet',1)
   var body = "0x2006"
   uo.set( 'finddistance', '12' )
   uo.ignorereset()
   uo.findtype( "-1", "-1", "ground" )
   while uo.findcount()
      if uo.IsNPC( 'finditem' ) || uo.getGraphic( 'finditem' ) == body then
         uo.click( 'finditem' )
      endif
      uo.ignore( 'finditem' )
      uo.findtype( "-1", "-1", "ground" )
   wend
   uo.ignorereset()
   UO.Set('quiet',0)
EndSub

sub MakeScreen()
   var filename=UO.GetInfo('shard')+' - '+UO.GetInfo('character')+' - '+str(UO.Date())+' - '+str(UO.Time())
   UO.Snap(filename)
end sub

sub AutoShooter()
   
   AllNames()
   wait(300)
   UO.DeleteJournal()
   MakeScreen()
   
endsub


Sub Ping()
   var max=0
   var min=999999
   var med=0
   var ping
   var loop
   For loop=1 to 10
      ping=EsperaAtraso()
      If ping>max Then
         max=ping
      End If
      If ping<min Then
         min=ping
      End If
      med=med+ping
   Next
   UO.CharPrint('self',0x0034,'Ping: '+str(min)+'-'+str(int(med/10))+'-'+str(max))
End Sub
;		; }
; 2.02.001 - Teste de Atraso do Servidor ; {
Sub PingTeste()
   var loop, loop2, ping, print, max=0, min=99999, med=0, testePing=100
   UO.TextOpen()
   UO.TextClear()
   UO.TextPrint('Teste de ping com '+str(testePing)+' verificações:')
   UO.TextPrint('')
   If testePing>0 Then
      For loop=1 to testePing
         ping=EsperaAtraso()
         med=med+ping
         If ping>max Then
            max=ping
         End If
         If ping<min Then
            min=ping
         End If
         print=str(ping)
         If Len(str(ping))<8 Then
            For loop2=1 to 8-Len(str(ping))
               print=print+' '
            Next
         End If
         For loop2=1 to ping
            print=print+'|'
         Next
         UO.TextPrint(print)
      Next
      med=med/testePing
      UO.TextPrint('')
      UO.TextPrint('Ping Mínimo: '+str(min))
      UO.TextPrint('Ping Média: '+str(med))
      UO.TextPrint('Ping Máximo: '+str(max))
      UO.TextPrint('')
      If med<20 Then
         UO.TextPrint('Seu ping está MUITO BOM!')
      Else
         If med<50 Then
            UO.TextPrint('Seu ping está BOM')
         Else
            If med<100 Then
               UO.TextPrint('Seu ping está REGULAR')
            Else
               If med<200 Then
                  UO.TextPrint('Seu ping está RUIM')
               Else
                  UO.TextPrint('Seu ping está MUITO RUIM!!!!!')
               End If
            End If
         End If
      End If
   Else
      UO.TextPrint('Configurado para executar 0 vezes! Corrija este erro nas Definições de Usuário do autoload!')
   End If
End Sub

sub autopvp()
   var s,x,ip,p,b=0
   uo.exec('terminate potdelay')
   UO.SetGlobal('pd','0')
   uo.warmode(1)
   repeat
      wait(1)
   until uo.warmode()==1
   uo.warmode(0)
   UO.addobject('lt', 'laststatus')
   denovo:
   if uo.waiting() then
      uo.canceltarget()
   endif
   if uo.injournal('Magery canc|Targeting canc') then
      uo.warmode(1)
      repeat
         wait(1)
      until uo.warmode()==1
      uo.warmode(0)
   endif
   if uo.injournal('Voce venceu') then
      uo.exec('terminate all')
   endif
   if uo.warmode()==1 then
      uo.warmode(0)
      repeat
         wait(1)
      until uo.warmode()==0
   endif
   if uo.injournal('pode curar|Voce curou') then
      b=0
   end if
   uo.deletejournal()
   pots()
   x=uo.mana
   if ip==1 then
      goto magias
      ip=0
   endif
   if uo.poisoned('self') then
      p=0
      uo.cast('Cure','self')
      wait1:
      repeat
         wait(5)
      until uo.injournal('A magi|Voce nao') or x>uo.mana
      if uo.injournal('O veneno em') then
         ip=1
         uo.resend()
      endif
      if uo.mana>=x then
         if not rin('A magia|Voce nao')==1 then
            goto wait1
         endif
      endif
   else
      magias:
      if uo.getglobal('sp')=='1' then
         UO.SetGlobal('sp','')
         goto poison
      endif
      if p==2 then
         UO.SetGlobal('sp','')
         p=0
         goto exp
      endif
      if uo.getglobal('m')=='2' and uo.mana>80 then
         UO.SetGlobal('m','')
         uo.cast('Earthquake')
      else
         if uo.getglobal('m')=='3' then
            UO.SetGlobal('m','')
            uo.waittargettile('#0x400', str(uo.GetX('self')), str(uo.GetY('self')), STR(UO.GetZ('self')))
            uo.cast('Paralyze Field')
         else
            if uo.poisoned('lt') then
               exp:
               uo.waittargetobject('lt')
               uo.cast('Lightning')
            else
               poison:
               uo.waittargetobject('lt')
               uo.cast('Lightning')
               p=1
            endif
         endif
         repeat
            wait(1)
         until uo.injournal('Select target|sufficient|see the target')
      endif
      wait3:
      repeat
         if uo.injournal('Voce curou|pode curar') then
            uo.deletejournal('Voce curou')
            uo.deletejournal('pode curar')
            b=0
         endif
         if not uo.injournal('ser curado') then
            if uo.life<uo.str then
               if b==0 then
                  uo.bandageself()
                  repeat
                     wait(1)
                  until uo.injournal('Voce comeca|alguem envenenado|ser curado')
                  if uo.injournal('Voce comeca') then
                     b=1
                  endif
               endif
            endif
         endif
         wait(3)
      until uo.injournal('spell fizzles|Target is not') or x>uo.mana
      if uo.mana>=x then
         if not rin('spell fizzles|Target is not')==1 then
            goto wait3
         endif
      else
         if p==1 then
            p=2
         endif
      endif
      if p==1 then
         p=0
      endif
   end if
   goto denovo
end sub

sub autopvp2()
   var s,x,ip,p,b=0
   uo.warmode(1)
   repeat
      wait(1)
   until uo.warmode()==1
   uo.warmode(0)
   UO.addobject('lt', 'laststatus')
   denovo:
   if uo.waiting() then
      uo.canceltarget()
   endif
   if uo.injournal('Magery canc|Targeting canc') then
      uo.warmode(1)
      repeat
         wait(1)
      until uo.warmode()==1
      uo.warmode(0)
   endif
   if uo.warmode()==1 then
      uo.warmode(0)
      repeat
         wait(1)
      until uo.warmode()==0
   endif
   uo.deletejournal()
   x=uo.mana
   if ip==1 then
      goto magias
      ip=0
   endif
   magias:
   if uo.getglobal('sp')=='1' then
      UO.SetGlobal('sp','')
      goto poison
   endif
   if uo.getglobal('m')=='2' and uo.mana>80 then
      UO.SetGlobal('m','')
      uo.cast('Earthquake')
   else
      if uo.getglobal('m')=='3' then
         UO.SetGlobal('m','')
         uo.waittargettile('#0x400', str(uo.GetX('self')), str(uo.GetY('self')), STR(UO.GetZ('self')))
         uo.cast('Paralyze Field')
      else
         if uo.poisoned('lt') then
            exp:
            uo.waittargetobject('lt')
            uo.cast('Magic Arrow')
         else
            poison:
            uo.waittargetobject('lt')
            uo.cast('Magic Arrow')
            p=1
         endif
      endif
      repeat
         wait(1)
      until uo.injournal('Select target|sufficient|see the target')
   endif
   wait3:
   if uo.mana>=x then
      if not rin('spell fizzles|Target is not')==1 then
         goto wait3
      endif
   else
      if p==1 then
         p=2
      endif
   endif
   if p==1 then
      p=0
   endif
end if
goto denovo
end sub

sub rin(text)
   var s
   while uo.injournal(text)
      s=uo.journalserial(uo.injournal(text)-1)
      if s=='0xFFFFFFFF' or s==uo.getserial('self') then
         return 1
      else
         uo.setjournalline(uo.injournal(text)-1,'')
      endif
   wend
endsub

sub sp()
   ag:
   If (UO.LastMessage()=="Voce esta paralizado.") <>0 Then
      if rin('Voce esta paralizado.')==1 then
         uo.exec('terminate autopvp2')
         uo.exec('exec exploo')
         Wait(1500)
         uo.deletejournal()
         uo.exec('exec autopvp2')
      endif
   endif
   wait(60)
   goto ag
end sub

sub pots()
   if uo.mana<30 then
      if uo.getglobal('pd')=='0' then
         repeat
            uo.exec('exec mana')
         until uo.mana>30 or uo.injournal('No item found')
         uo.exec('exec potdelay')
      endif
   endif
   if uo.life<40 and uo.mana>55 then
      if uo.getglobal('pd')=='0' then
         repeat
            uo.exec('exec life')
         until uo.injournal('You put|No item found')
         uo.exec('exec potdelay')
      endif
   endif
   if uo.injournal('Pocao: 0') then
      uo.exec('terminate potdelay')
      UO.SetGlobal('pd','0') 
   endif
end sub

sub potdelay()
   UO.SetGlobal('pd','1') 
   wait(11500)
   UO.SetGlobal('pd','0') 
endsub   


