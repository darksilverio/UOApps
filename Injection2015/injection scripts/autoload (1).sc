# **************************************** #
# ** Autoload do Pai de Familia, tfg 2017 ** #
# **************************************** #


############ EQUIP ############
# set_one:: addobject one
# set_two :: addobject two
# set_blood :: addobject blood (arma blood)
# battle_axe :: Equipar Battle Axe
# onehand :: Equipar Kriss/kat/vikin + Heater *(arrumar os type)
# two :: Equipar war fork/axe/battle axe/exec axe *(arrumar o macro)
# bow :: Equipar bow/atatack latsstatus*
# pvmblood :: Equipar onehand blood + shield

########### LOOT ###########
# bau :: Lootear Bau de tesouro
# lootplayer :: Looteia player
# brb :: reabastecer
# set_bagR :: addobject bagR (bag dos reg e pot)

########### SUSTAIN ###########
# :: bandself :: Bandagem self
# cure :: Tomar Potion Greater Cure*
# lb :: Tomar Life boost*
# mb :: Tomar mana boost*
# refeel :: Tomar refeeling*
# stamina :: Tomar pote stamina
# inv :: Tomar pote de inv
# buffs :: Ra + pr + mr + str

########### MECHANICS ###########
# ress :: Ressa inv com band, se n tem, An ort *
# free :: MA na explo, ou an ort
# lag :: Printa lag na tela
# dgate :: Dispela Gate proximo
# safe :: Recall safe + pot inv
# plz :: Casta paralize + LT (pref scroll)
# fs :: Casta FS +  LT (pref scroll)
# ma :: MA + LT
# clum :: Clumsy + LT
# light :: Lightning +  LT
# wall :: Stone Wall SEM target
# mr :: Casta magic reflect/self

########### WORKS ###########
# :: taming :: taming + shrink *


sub tame() 
   uo.print('Selecione o animal') 
   uo.exec('addobject TOT') 
   while uo.targeting() 
      wait(100) 
   wend 
   while not uo.dead()
      uo.deletejournal()
      uo.usetype('0x0EB2')
      uo.waittargetobject('TOT')
      repeat
         wait(500)
      until uo.injournal('falhou|novo mestre| too far')
      if uo.injournal('novo mestre') then          
         uo.usetype('0x0F0E', '0x0076')    
         uo.waittargetobject('TOT') 
         uo.usetype('0x0F0E', '0x0076')                               
      endif
   wend
End sub


sub wyrm_leather()
   
   VAR sewingKit = '0x0F9D'
   VAR wyrmCouro = '0x1078'
   VAR i
   
   Dim partes[5]
   
   partes[1] = "Gorget"
   partes[2] = "Gloves"
   partes[3] = "Sleeves"
   partes[4] = "Legs"
   partes[5] = "Tunic"
   #partes[6] = "Cap"
   
   repeat
      for i = 1 to 5
         uo.WaitTargetType(wyrmCouro) 
         uo.usetype(sewingKit)
         uo.waitmenu('Wyrm', partes[i]) #para fazer dragon so mudar aqui
         repeat
            uo.deleteJournal()
            wait(200)
            #UO.print('Entrou no repeat')
         until uo.injournal('You put|falhou|cancelada')
      next
   until uo.Count(wyrmCouro) < 3
   
   uo.charPrint('self','0x024f','Macro Finalizado!')
   
end sub

sub mining() 
   var dir, px, py, x, y
   uo.print('Inicializando..')
   uo.print('Macro feito por get Rekt (TFG Shard)')
   seed()
   while 1 == 1     
      if uo.dead() then
         morreu()
      endif
      #checarlimite() #so mecha aqui se souber como configurar o checar limite
      uo.print("Andando!")
      walk()       
      for x = -2 to 2
         for y = -2 to 2
            UO.DeleteJournal()
            while not UO.InJournal("There is nothing|no line|far away|Try mining|mine so close|That is too") and not uo.dead()
               if UO.InJournal("You are tired of mining today") then
                  uo.exec('terminate mining')
               endif
               UO.usetype('0x097B')
               UO.DeleteJournal()
               uo.waittargettile('#0x400', str(uo.GetX() + x), str(uo.GetY() + y), STR(UO.GetZ('self')))
               uo.usetype('0x0E85')
               if UO.InJournal("Iron|Blackrock|Bloodrock|Gold|Mytheril|Verite|Valorite") then
                  uo.exec('mining')
                  wait (100)
                  uo.exec('terminate mining')
               endif
               repeat
                  wait(800)
               until UO.InJournal("You put|some rocks|There is nothing|no line|far away|target|Try mining|mine so close|That is too|nao encontrou") or uo.dead() 
            wend                                                                                                                                                    
         next
      next
   wend
end sub

sub Target() 
   
   var totalFriend=6
   var temp, name, t = 0, k, a, findResult = 0
   DIM friend[6]
   friend[0]='DragonlorD'
   friend[1]='ZilD'
   friend[2]='Sonic Wing'
   friend[3]='JaY AdAmS'
   friend[4]='Hlds'
   friend[5]='Pai de Familia'
   friend[6]='KarnOs'
   
   uo.set('finddistance','10')
   uo.ignore('self')
   for t=0 to 1
      
      uo.set('finddistance','10')
      uo.ignore('self')
      for t=0 to 1
         repeat
            uo.findtype('0x0190','-1','ground')
            findResult = uo.findCount()
            if findResult == 0 then
               uo.findtype('0x0191','-1','ground')
               findResult = uo.findCount();
            endif
            temp = 0
            name = uo.getName('finditem')
            for k=0 to totalFriend
               if name == friend[k] and uo.findcount() <> 0 then
                  uo.Ignore('finditem')
                  k = totalFriend
                  temp = 1
               end if
            next
            if temp==0 and findResult <> 0 then
               a = uo.getserial('finditem')
               uo.addobject('lasttarget',a)
               uo.addobject('laststatus',a)
               uo.ignore('finditem')
               if uo.getnotoriety('finditem')>= 1 then
                  uo.waittargetobject('lasttarget') 
                  uo.waittargetobject('laststatus')
                  uo.attack(a)
                  UO.Print('TARGET: '+UO.GetName('LastTarget'))
                  UO.msg('.gc TARGET: '+UO.GetName('LastTarget'))
               end if
               
               return false
            end if
         until findResult == 0
         if findResult == 0 then
            uo.IgnoreReset()
         end if
      next
      uo.fontcolor(UO.Random(100))
      uo.Print('NINGUEM NO TARGET') 
end sub

Sub fstrike() 
   uo.waittargetobject('lasttarget')
   uo.waittargetobject('laststatus')
   if uo.count('0x1F5F') then
      uo.usetype('0x1F5F')
   else
      uo.cast('Flame Strike')
   endif
   #UO.UseType('0x1F5F')
End Sub


sub buffs()
   uo.cast('Reactive Armor','self')
   wait(1800)
   uo.cast('Arch Protection','self')
   wait(3500)
   uo.cast('Magic Reflection','self')
   wait(3600)
   uo.cast('Strength','self')
end sub

sub fishing() 
   var mx, my, mz, i, j
   var dir=0
   var local=0
   DIM direcao[4]
   uo.print('Selecione o bau') 
   uo.exec('addobject Bag') 
   while uo.targeting() 
      wait(100) 
   wend 
   inicio:
   mx = UO.GetX("self") 
   my = UO.GetY("self") 
   mz = UO.GetZ("self") 
   UO.DeleteJournal() 
   while true
      for i = mx-4 to mx+4 
         for j = my -4 to my+4 
            if UO.dead() then 
               return 
            endif 
            while not UO.Hidden() 
               UO.Warmode("0") 
               uo.print("hiding...") 
               UO.UseSkill("Hiding") 
               wait(4000) 
            wend 
            UO.Print("Now Fishing In: "+str(mx-i)+" "+str(my-j)) 
            while not UO.InJournal("no fish here") and not UO.InJournal("location") and not UO.InJournal("far away") and not UO.InJournal("in water") 
               UO.DeleteJournal() 
               UO.Waittargettile("1341", str(i), str(j), str(mz)) 
               UO.Usetype("0x0DBF") ;FishingPole 
               if UO.dead() then 
                  return 
               endif 
               if UO.Weight>660 then 
                  return 
               endif 
               while not UO.InJournal("You pull") and not UO.InJournal("location") and not UO.InJournal("no fish") and not UO.InJournal("but fail") and not UO.InJournal("far away") and not UO.InJournal("in water") 
                  wait (100) 
                  if UO.InJournal("You pull") then 
                     UO.SetReceivingContainer('Bag') 
                     UO.findtype('0x09CC','0x0000','backpack') ;fish 
                     if uo.findcount() then
                        uo.moveitem('finditem','0','Bag')
                        wait (500) 
                     endif	
                     UO.findtype('0x09CD','0x0000','backpack') ;fish 
                     if uo.findcount() then
                        uo.moveitem('finditem','0','Bag')
                        wait (500) 
                     endif	 
                     UO.findtype('0x09CE','0x0000','backpack') ;fish 
                     if uo.findcount() then
                        uo.moveitem('finditem','0','Bag')
                        wait (500) 
                     endif	 
                     UO.findtype('0x09CF','0x0000','backpack') ;fish 
                     if uo.findcount() then
                        uo.moveitem('finditem','0','Bag')
                        wait (500) 
                     endif	 
                     UO.findtype('0x3B03','0x0000','backpack') 
                     if uo.findcount() then
                        uo.moveitem('finditem','0','Bag')
                        wait (500) 
                     endif	
                     UO.findtype('0x0DD6','0x05F6','backpack') ;Truly rare fish 
                     if uo.findcount() then
                        uo.moveitem('finditem','0','Bag')
                        wait (500) 
                     endif	 
                     UO.findtype('0x0DD6','0x01BB','backpack') ;Prize fish 
                     if uo.findcount() then
                        uo.moveitem('finditem','0','Bag')
                        wait (500) 
                     endif	 
                     UO.UnSetReceivingContainer() 
                  end if 
               wend 
            wend 
            UO.DeleteJournal() 
            local=local+1
            if local >=10 then
               direcao[0]='forward'
               direcao[1]='left'
               direcao[2]='back'
               direcao[3]='right'
               uo.msg(direcao[dir])
               dir=dir+1
               if dir>3 then
                  dir=0
               endif
               wait(10000)
               uo.msg('stop')
               local=0
               goto inicio:
            endif
         next 
      next 
   wend
end sub 

sub brb()
   UO.Print('Escolha a bag')
   UO.Exec('addobject bagR')
   while UO.Targeting()
      wait(100)
   wend
   var x, aux = 0
   var qtd = 100
   var bau = '0x400685E2'
   var bagR = '0x40049666'   
   var backpack = '0x4011CC3E'
   var delay = 700
   dim items[19]
   items[0]  =  '0x0F7B,-1,100,bagR'  		;BM
   items[1]  =  '0x0F85,-1,100,bagR'  		;GS
   items[2]  =  '0x0F8C,-1,100,bagR'  		;SA
   items[3]  =  '0x0F88,-1,100,bagR'  		;NS
   items[4]  =  '0x0F8D,-1,100,bagR'  		;SS
   items[5]  =  '0x0F86,-1,100,bagR'  		;MR
   items[6]  =  '0x0F7A,-1,100,bagR'  		;BP
   items[7]  =  '0x0F84,-1,100,bagR'  		;GA
   items[8]  =  '0x0F82,0x017F,25,bagR'   	;REFILING
   items[9]  =  '0x0F82,0x0532,50,bagR'   	;MANA
   items[10] =  '0x0F82,0x0026,50,bagR'    	;LIFE
   items[11] =  '0x0F0E,0x008F,15,bagR'   	;CURE
   items[12] =  '0x0F0E,0x0022,25,bagR'   	;STAN
   items[13] =  '0x1F5F,-1,55,bagR'     	;FS
   items[14] =  '0x0E21,-1,100,bagR'    	;bands
   items[15] =  '0x0F0E,0x0480,10,bagR'   	;TOTAL MANA
   items[16] =  '0x0F0E,0x0001,7,bagR'   	;INVS
   items[17] =  '0x0F0E,0x0000,20,bagR'   	;BOTTLE
   items[18] =  '0x0F0E,0x0076,3,bagR'   	;SHIRINK
   items[19] =  '0x0F3F,0x0000,500,bagR'   	;ARROW     
   
   uo.useobject(bau)  
   uo.useobject('backpack')
   uo.useobject('bagR')
   
   wait(700)
   
   for x = 0 to GetArrayLength(items)-1   
      uo.findtype(GetWord(items[x],1,','),GetWord(items[x],2,','),GetWord(items[x],4,','))
      if uo.getquantity('finditem') > 0 AND uo.getquantity('finditem') > val(GetWord(items[x],3,',')) then
         uo.moveitem('finditem',uo.getquantity('finditem') - val(GetWord(items[x],3,',')), bau)
         wait(delay)
      endif
      if uo.getquantity('finditem') < val(GetWord(items[x],3,',')) then 
         aux = uo.getquantity('finditem')
         uo.findtype(GetWord(items[x],1,','),GetWord(items[x],2,','),bau)
         uo.moveitem('finditem', val(GetWord(items[x],3,',')) - aux, GetWord(items[x],4,','))
         wait(delay)
      endif       
   next 
endsub

sub cavar() 
   uo.waittargetobject('lasttarget')   
   UO.UseType('0x0F39') 
end sub


sub onehand() 
   uo.waittargetobject('lasttarget')
   UO.UseObject('one') ; UID de itens
   uo.usetype('0x1B76')
   uo.usetype('0x1BC4')
   uo.attack ('laststatus')
   uo.attack ('lasttarget') 
end sub

sub two() 
   uo.waittargetobject('lasttarget')
   UO.UseObject('two') ; UID de itens
   uo.attack ('laststatus')
   uo.attack ('lasttarget') 
end sub

sub pvmblood()
   uo.waittargetobject('lasttarget')
   UO.UseObject('blood') ; UID de itens
   uo.usetype('0x1B76')
   uo.usetype('0x1BC4')
   uo.attack ('laststatus')
   uo.attack ('lasttarget') 
end sub 

sub mr()
   uo.cast('Magic Reflect')
   uo.waittargetself()
   wait(500)
endsub

sub wall()
   uo.waittargetlast()
   uo.cast('Wall of Stone')
endsub

sub light()
   uo.waittargetlast()
   uo.cast('Lightning')
endsub

Sub clum() 
   uo.waittargetobject('lasttarget')   
   uo.waittargetobject('laststatus')   
   uo.cast('Clumsy')            
End Sub

Sub ma() 
   uo.waittargetobject('lasttarget')   
   uo.waittargetobject('laststatus')   
   uo.cast('Magic Arrow')            
End Sub

Sub fs() 
   uo.waittargetobject('lasttarget')   
   uo.waittargetobject('laststatus')   
   if uo.count('0x1F5F') then
      uo.usetype('0x1F5F')
   else
      uo.cast('Flame Strike')
   endif
   #UO.UseType('0x1F5F')          
End Sub

Sub plz() 
   uo.waittargetobject('lasttarget')   
   uo.waittargetobject('laststatus')   
   if uo.count('0x1F52') then
      uo.usetype('0x1F52')
   else
      uo.cast('Paralyze')
   endif       
   #uo.cast('Paralyze')      
End Sub

sub Inv()
   UO.UseType('0x0F0E','0x0001')
end sub	

sub Pot_Refresh()
   uo.usetype("0x0F0E","0x0022")
end sub

sub dgate()
   uo.cast('Dispel')
   uo.waittargetground(0x0F6C) 
   wait(200)
   uo.disarm()
end sub

sub taming() 
   uo.print('Selecione o animal') 
   uo.exec('addobject TOT') 
   while uo.targeting() 
      wait(100) 
   wend 
   while not uo.dead()
      uo.deletejournal()
      uo.usetype('0x0EB2')
      uo.waittargetobject('TOT')
      repeat
         wait(500)
      until uo.injournal('falhou|novo mestre| too far')
      if uo.injournal('novo mestre') then          
         uo.usetype('0x0F0E', '0x0076')    
         uo.waittargetobject('TOT') 
         uo.usetype('0x0F0E', '0x0076')                               
      endif
   wend
End sub

sub lag()
   var a=0
   uo.deletejournal()
   uo.click('backpack')
   repeat
      a=a+1
      wait(1)
   until uo.injournal('backpack')
   uo.serverprint('Ping: '+ STR(A*2) + ' ms')
end sub

sub free()
   uo.waittargettype('0x0F02', '0x0000')# Type,Color Lesser Explosion
   uo.cast('Magic Arrow')
   if uo.count('0x0F02','0x0000') <= 0 then
      uo.waittargetself()
      uo.cast('Dispel')
   end if
endsub

Sub safe()
   uo.say(".recall 1,4")
   UO.UseType('0x0F0E','0x0001')
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

sub bandself()
   uo.waittargetself()
   uo.usetype('0x0E21')
end sub

sub bow()   
   uo.usetype('0x13B1')	    	
   uo.exec("warmode 1")
   uo.attack('laststatus')   
end sub

sub refeel()
   uo.usetype("0x0F07","0x0000")
end sub

sub mb()
   uo.usetype("0x0F07","0x0000")
end sub

sub lb()
   uo.usetype("0x0F07","0x0000")
end sub

sub cure()
   uo.usetype("0x0F0E","0x008F")
end sub


sub bau()
   
   UO.Print('Escolha o Bau')
   UO.Exec('addobject bau')
   while UO.Targeting()
      wait(100)
   wend
   UO.FindType(0x14EB,'-1','bau')
   uo.moveitem('finditem', 'all', 'my' ) 
   wait(1000)
   UO.FindType(0x0F7A,'-1','bau')
   uo.moveitem('finditem', 'all', 'my' ) 
   wait(1000)
   UO.FindType(0x0F84,'-1','bau')
   uo.moveitem('finditem', 'all', 'my' ) 
   wait(1000)
   UO.FindType(0x0F8C,'-1','bau')
   uo.moveitem('finditem', 'all', 'my' ) 
   wait(1000)
   UO.FindType(0x0F85,'-1','bau')
   uo.moveitem('finditem', 'all', 'my' ) 
   wait(1000)
   UO.FindType(0x0F7B,'-1','bau')
   uo.moveitem('finditem', 'all', 'my' ) 
   wait(1000)
   UO.FindType(0x0F88,'-1','bau')
   uo.moveitem('finditem', 'all', 'my' ) 
   wait(1000)
   UO.FindType(0x0F86,'-1','bau')
   uo.moveitem('finditem', 'all', 'my' ) 
   wait(1000)
   UO.FindType(0x0F8D,'-1','bau')
   uo.moveitem('finditem', 'all', 'my' ) 
   wait(1000)
   UO.FindType(0x0F89,'-1','bau')
   uo.moveitem('finditem', 'all', 'my' ) 
   wait(1000)
   UO.FindType(0x0EED,'-1','bau')
   uo.moveitem('finditem', 'all', 'my' ) 
   wait(1000)
   UO.FindType(0x0F13,'-1','bau')
   uo.moveitem('finditem', 'all', 'my' ) 
   wait(1000)
   UO.FindType(0x0F10,'-1','bau')
   uo.moveitem('finditem', 'all', 'my' ) 
   wait(1000)
   UO.FindType(0x0F26,'-1','bau')
   uo.moveitem('finditem', 'all', 'my' ) 
   wait(1000)
   
endsub
