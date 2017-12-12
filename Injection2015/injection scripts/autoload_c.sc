# **************************************** #
# ** KINGDOMS SCRIPT 1.0 // by Sargauth ** #
# **************************************** #


# ##################################################### #
# ################ LISTA DE COMANDOS ################## #
# ##################################################### #

# :: AFK ->> Away
# :: Arm_Kryss ->> Armar Chaos Shield + Kryss
# :: Arm_Viking ->> Armar Chaos Shield + Viking
# :: Arm_Arco ->> Armar Arco
# :: Arm_Cros ->> Armar Cros
# :: Disarm ->> Disarmar
# :: Despir ->> Tirar toda roupa
# :: Vestir_Chain ->> Vestir Loot - Chain (+ Ethereal Horse)
# :: Vestir_Plate ->> Vestir Loot - Plate (+ Ethereal Horse)
# :: Cure_Bands ->> Soltar Cure e usar Bandagem
# :: Pot_Cure ->> Tomar Poção de Cura
# :: Pot_Life ->> Tomar Poção de Life
# :: Pot_Mana ->> Tomar Poção de Mana
# :: Pot_Invis ->> Tomar Poção de Invis
# :: Pot_Refresh ->> Tomar Poção de Refresh
# :: Scroll_FS ->> Scroll de Flame Strike / Last Target
# :: Flame_Strike ->> Flame Strike / Last Target
# :: Paralyze ->> Paralyze / Last Target
# :: Poison ->> Poison / Last Target
# :: Dispel ->> Dispel / Last Target
# :: Lightning ->> Lightning / Last Target
# :: Paralyze_Field ->> Paralyze Field / Last Target
# :: Paralyze_Self ->> Paralyze Field / Target Self
# :: Wall_of_Stone ->> Wall of Stone / Last Target
# :: Heal_Bands ->> Soltar Heal e usar Bandagem
# :: Magic_Arrow_Self ->> Magic Arrow / Target Self
# :: Magic_Arrow ->> Magic Arrow / Last Target
# :: Harm ->> Harm / Last Target
# :: Bandagem ->> Usar Bandagem (sem target)
# :: Bandagem_Self ->> Usar Bandagem / Target Self
# :: Poison_Kryss ->> Poisonar Kryss
# :: Poison_Viking ->> Poisonar Viking
# :: Fazer_FS ->> Fazer Scrolls de FS
# :: Fazer_Invis ->> Fazer Pots de Invis
# :: Fazer_Shrink ->> Fazer Pots de Shrink
# :: Macro_Healing ->> Macroar Healing
# :: Taming ->> Macroar Taming (galinha)
# :: Magery_Medit ->> Macroar Magery e Meditation
# :: Anatomy ->> Macroar Anatomy
# :: Animal_Lore ->> Macroar Animal Lore
# :: Hiding_Stealth ->> Macroar Hiding e Stealth
# :: BS ->> Macroar Blacksmithing
# :: Inscription ->> Macroar Inscription
# :: Tinkering ->> Macroar Tinkering



# ##################################################### #
# ################ INICIO DAS MACROS ################## #
# ##################################################### #


sub AlchemyLP()
   var a_mortar_and_pleste='0x0E9B'
   var Nightsade='0x0F88'
   uo.Automenu('What sort of potion do you want to make?','Lesser Poison')
   repeat 
      uo.DeleteJournal() 
      uo.UseType(Nightsade) 
      repeat 
         wait(500) 
      until uo.InJournal('You put') or uo.InJournal('Voce falhou em')
   until (uo.Count(Nightsade)<=2)
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


sub battle_axe()
   uo.usetype('0x0F47')
   uo.attack('lasttarget')
end sub


# ------------------------------------ #
# ---------- Macro de Away ----------- #
# ------------------------------------ #

sub AntiParalize()
   Var protec = 0
   while true
      wait(10)
      if uo.injournal('You are frozen and can not move.') then
         uo.deletejournal()
         if uo.count('0x0F02') then
            uo.cast('Clumsy')
            uo.waittargettype('0x0F02')
            uo.deletejournal()
         else
            UO.Cast('Dispel','self')
         endif
         while protec <= 1000
            protec = protec + 1
            wait(1)
         wend
         protec = 0
         uo.deletejournal()
      end if
   wend 
end sub

sub AFK()
   uo.say("Estou Away...")
   wait(15000)
   uo.say(",exec AFK")
end sub

# ------------------------------------ #
# ---- Arma magica Escudo loko-- ----- #
# ------------------------------------ #

sub Arm_Especial()
   uo.usetype('0x1B7B')
   uo.usetype('0x1404')
end sub


# ------------------------------------ #
# ---- Usar Heater Shield e Kryss ----- #
# ------------------------------------ #

sub Arm_Heater()
   uo.usetype('0x1B76')
   uo.usetype('0x1400')
   uo.attack('lasttarget')
end sub

# ------------------------------------ #
# ---- Usar Heater Shield e War Fork-- #
# ------------------------------------ #

sub Arm_War_fork()
   uo.usetype('0x1404')
   uo.attack('lasttarget')
end sub

# ------------------------------------ #
# ---- Usar Chaos Shield e Kryss ----- #
# ------------------------------------ #

sub Arm_Kryss()
   uo.usetype('0x13AF')
   uo.usetype('0x13B9')
   uo.usetype('0x1400')
   uo.usetype('0x1B76')
   uo.usetype('0x1BC4')
   uo.usetype('0x13B5')
   uo.usetype('0x13FE')
   uo.usetype('0x1BC3')
   uo.attack('lasttarget')
end sub



# ------------------------------------ #
# ---- Usar Chaos Shield e Viking ---- #
# ------------------------------------ #

sub Arm_Viking()
   uo.usetype('0x13B9')
   uo.usetype('0x1B76')
end sub

# ------------------------------------ #
# ---- Usar Shiel e Katana ---- #
# ------------------------------------ #

sub Arm_Katana()
   uo.usetype('0x1B76')
   uo.usetype('0x13FF')
end sub



# ------------------------------------ #
# ------------ Usar Arco ------------- #
# ------------------------------------ #

sub Arm_Arco()
   uo.usetype('0x13B2')
end sub


# ------------------------------------ #
# ------------ Usar CrosBow----------- #
# ------------------------------------ #

sub Arm_Cros()
   uo.usetype('0x13FD')
end sub


# ------------------------------------ #
# ------------ Disarmar -------------- #
# ------------------------------------ #

sub Disarm()
   uo.say('.disarm')
   uo.disarm()  
end sub



# ------------------------------------ #
# - Vestir Chain, Ropas e Musta Ethe - #
# ------------------------------------ #

sub Vestir_Chain()
   uo.usetype("0x13BE") 
   uo.usetype("0x13EE")
   uo.usetype("0x13BB")
   uo.usetype("0x13EB")
   uo.usetype("0x13BF")
   uo.usetype("0x170B")
   uo.usetype("0x1EFD")
   uo.usetype("0x1541")
   uo.usetype("0x1086")
   uo.usetype("0x108A")
   uo.usetype("0x1089")
   uo.usetype("0x1F03")
   uo.usetype("0x20DD")
   
end sub

# ------------------------------------ #
# - Vestir Plate, Ropas e Musta Ethe - #
# ------------------------------------ #

sub Vestir_Plate()
   uo.usetype("0x1412") 
   uo.usetype("0x1415")
   uo.usetype("0x1410")
   uo.usetype("0x1414")
   uo.usetype("0x1411")
   uo.usetype("0x170B")
   uo.usetype("0x1EFD")
   uo.usetype("0x1541")
   uo.usetype("0x1086")
   uo.usetype("0x108A")
   uo.usetype("0x1089")
   uo.usetype("0x1F03")
   uo.usetype("0x20DD")
   
end sub



# ------------------------------------ #
# - Tirar toda a Roupa/Armadura/Joia - #
# ------------------------------------ #

sub Despir()
   uo.undress()
   uo.usetype("0x170B")
   uo.usetype("0x1EFD")
   uo.usetype("0x1541")
end sub



# ------------------------------------ #
# ----- Magia de Cura + Bandagem ----- #
# ------------------------------------ #

sub Cure_Bands()
   uo.waittargetself()
   uo.cast('Cure')
   wait(1300)
   uo.waittargetself()
   uo.usetype('0x0E21')
end sub



# ------------------------------------ #
# ---------- Poção de Cura ----------- #
# ------------------------------------ #

sub Pot_Cure()
   uo.usetype("0x0F07","0x0000")
end sub



# ------------------------------------ #
# ---------- Poçao de Mana ----------- #
# ------------------------------------ #

sub Pot_Mana()
   uo.usetype("0x0F82","0x0532")
end sub



# ------------------------------------ #
# ---------- Poção de Life ----------- #
# ------------------------------------ #

sub Pot_Life()
   uo.usetype("0x0F82","0x017F")
end sub



# ------------------------------------ #
# -------- Poçao de Estamina --------- #
# ------------------------------------ #

sub Pot_Refresh()
   uo.usetype("0x0F0E","0x0022")
end sub



# ------------------------------------ #
# ----- Poção de Invisibilidade ------ #
# ------------------------------------ #

sub Pot_Invis()
   uo.usetype("0x0F09","0x0631")
end sub	



# ------------------------------------ #
# ---- Scroll de Flame Strike / LT --- #
# ------------------------------------ #

sub Scroll_FS()
   uo.waittargetlast()
   uo.usetype('0x1F5F')
endsub



# ------------------------------------ #
# ----- Magia Flame Strike / LT ------ #
# ------------------------------------ #

sub Flame_Strike()
   uo.waittargetlast()
   uo.cast('Flame Strike')
endsub



# ------------------------------------ #
# ------- Magia Paralyze / LT -------- #
# ------------------------------------ #

sub Paralyze()
   uo.waittargetlast()
   uo.cast('Paralyze')
endsub



# ------------------------------------ #
# -------- Magia Poison / LT --------- #
# ------------------------------------ #

sub Poison()
   uo.waittargetlast()
   uo.cast('Poison')
endsub



# ------------------------------------ #
# -------- Magia Dispel / LT --------- #
# ------------------------------------ #

sub Dispel()
   uo.waittargetself()
   uo.cast('Dispel')
endsub



# ------------------------------------ #
# ------ Magia Lightning / LT -------- #
# ------------------------------------ #

sub Lightning()
   uo.waittargetlast()
   uo.cast('Lightning')
endsub



# ------------------------------------ #
# ---- Magia Paralyze Field / LT ----- #
# ------------------------------------ #

sub Paralyze_Field()
   uo.waittargetlast()
   uo.cast('Paralyze Field')
endsub



# ------------------------------------ #
# ---- Magia Paralyze Field / TS ----- #
# ------------------------------------ #

sub Paralyze_Self()
   uo.waittargetself()
   uo.cast('Paralyze Field')
endsub



# ------------------------------------ #
# ----- Magia Wall of Stone / LT ----- #
# ------------------------------------ #

sub Wall_of_Stone()
   uo.waittargetlast()
   uo.cast('Wall of Stone')
endsub



# ------------------------------------ #
# ------ Magia Heal + Bandagem ------- #
# ------------------------------------ #

sub Heal_Bands()
   uo.waittargetself()
   uo.cast('Heal')
   wait(500)
   uo.waittargetself()
   uo.usetype('0x0E21')
end sub



# ------------------------------------ #
# ----- Magia Magic Arrow / TS ------- #
# ------------------------------------ #

sub Magic_Arrow_Self()
   uo.waittargetself()
   uo.cast('Magic Arrow')
endsub



# ------------------------------------ #
# ----- Magia Magic Arrow / LS ------- #
# ------------------------------------ #

sub Magic_Arrow()
   uo.waittargetlast()
   uo.cast('Magic Arrow')
endsub



# ------------------------------------ #
# --------- Magia Harm / LT ---------- #
# ------------------------------------ #

sub Harm()
   uo.waittargetlast()
   uo.cast('Harm')
endsub



# ------------------------------------ #
# Usar Bandagem (Sem Target / Manual) #
# ------------------------------------ #

sub Bandagem()
   uo.usetype('0x0E21')
endsub



# ------------------------------------ #
# ---------- Usar Bandagem ----------- #
# ------------------------------------ #

sub Bandagem_Self()
   uo.waittargetself()
   uo.usetype('0x0E21')
   
endsub



# ------------------------------------ #
# ----- Macro Infinito de Healing ---- #
# ------------------------------------ #

sub Macro_Healing()
   uo.waittargetself()
   uo.usetype('0x0E21')
   wait(4000)
   uo.say(",exec Macro_Healing")
   
endsub



# ------------------------------------ #
# ---------- Poisonar Kryss ---------- #
# ------------------------------------ #

sub Poison_Kryss()
   uo.waittargettype("0x1400")
   uo.usetype("0x0F0E","0x0044")
end sub



# ------------------------------------ #
# --------- Poisonar Viking ---------- #
# ------------------------------------ #

sub Poison_Viking()
   uo.waittargettype("0x13B9")
   uo.usetype("0x0F0A","0x0000")
end sub


# ------------------------------------ #
# --------- Poisonar War Fork--------- #
# ------------------------------------ #

sub Poison_War_Fork()
   uo.waittargettype("0x1404")
   uo.usetype("0x0F0A","0x0000")
end sub

# ------------------------------------ #
# --- Macro de Taming (Com Galinha) -- #
# ------------------------------------ #

sub tame()
   uo.addobject('animaltame')
   while uo.targeting()
      wait(100)
   wend
   var tgt = uo.getserial("animaltame")
   if tgt == "0x00000000" then
      uo.deleteobject('animaltame')
      uo.exec('terminate tame')
   endif
   uo.deletejournal()
   while not uo.dead()
      uo.deletejournal()
      uo.usetype('0x0EB2')
      uo.waittargetlast()
      repeat
         wait(500)
      until uo.injournal('foi domesticado|Voce perdeu|too far|sucesso|você nao tem|Voce esta|falhou|aceita|already belong')
      if uo.injournal('already belong') then
         uo.waittargetobject('animaltame');
         uo.findtype('0x0F0E','0x0076',"backpack")
         uo.useobject(finditem)
         wait(500)
         uo.msg('All Come')
         uo.msg('All Come')
         wait(500)
         uo.recall("0x40056F97", 1)
         wait(500)
         uo.deleteobject('animaltame')
         uo.exec('terminate tame')
      endif
   wend
endsub

sub Tamingxx() 
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

sub TamingX()
   UO.WaitTargetLast() 
   wait(700)
   uo.usetype('0x0EB2')
   UO.DeleteJournal()
   While not UO.InJournal("O animal aceitou") and not UO.InJournal("Voce falhou") and not UO.InJournal("is already tame") 
      Wait(500) 
      If UO.InJournal("O animal aceitou") then        
         uo.usetype('0x0F0E', '0x0076')
         UO.WaitTargetLast()
      End If 
   Wend 
End sub



# ------------------------------------ #
# -- Fazer Scrolls de Flame Strike --- #
# ------------------------------------ #

sub clickgate() 
   UO.SendGumpSelect(1) 
end sub 



# ------------------------------------ #
# ------ Fazer Poções de Invis ------- #
# ------------------------------------ #

sub Fazer_Invis() 
   uo.msg("All Release")
   Wait(12000)
   repeat
   wend 
end sub 



# ------------------------------------ #
# ------ Fazer Poções de Shrink ------ #
# ------------------------------------ #

sub Fazer_Shrink() 
   var Batwings='0x0F78' 
   uo.Automenu('What sort of potion do you want to make?','Shrink') 
   repeat 
      uo.DeleteJournal() 
      uo.UseType(Batwings) 
      repeat 
         wait(500) 
      until uo.InJournal('You put') or uo.InJournal('You toss')
   until (uo.Count(Batwings)<=4)
end sub 



# ------------------------------------ #
# ---- Macroar Magery e Meditation --- #
# ------------------------------------ #

sub Magery_Medit() 
   uo.waittargetself()
   uo.cast('Magic Arrow')
   Wait(1500) 
   uo.say(",exec Magery_MeditX")
end sub

sub Magery_MeditX() 
   UO.Useskill("Meditation") 
   UO.DeleteJournal()
   While not UO.InJournal("You enter") and not UO.InJournal("You cannot")
      Wait(500) 
      If UO.InJournal("You cannot")then 
         uo.say(",exec Magery_MeditX")
      End If 
      If UO.InJournal("You are at")then 
         uo.say(",exec Magery_Medit")
End sub



# ------------------------------------ #
# --------- Macroar Anatomy ---------- #
# ------------------------------------ #

sub Anatomy() 
   uo.waittargetself()
   uo.Useskill('Anatomy')
   UO.DeleteJournal() 
   While not UO.InJournal("Evac looks") and not UO.InJournal("Voce nao")
      Wait(500) 
      If UO.InJournal("Evac looks") or UO.InJournal("Voce nao") then 
         uo.say(",exec Anatomy")
      End If 
   Wend 
End sub



# ------------------------------------ #
# ------- Macroar Animal Lore -------- #
# ------------------------------------ #

sub Animal_Lore() 
   uo.waittargetself()
   uo.Useskill('Animal Lore')
   UO.DeleteJournal() 
   While not UO.InJournal("Evac") and not UO.InJournal("Voce nao")
      Wait(500) 
      If UO.InJournal("Evac") or UO.InJournal("Voce nao") then 
         uo.say(",exec Animal_Lore")
      End If 
   Wend 
End sub



# ------------------------------------ #
# ----- Macroar Hiding e Stealth ----- #
# ------------------------------------ #

sub Hiding_Stealth() 
   uo.Useskill('Hiding')
   uo.say("guards")
   UO.DeleteJournal() 
   While not UO.InJournal("Voce nao") and not UO.InJournal("You have")
      Wait(500) 
      If UO.InJournal("Voce nao") or UO.InJournal("You have") then 
         uo.say(",exec Hiding_StealthX")
      End If 
   Wend 
end sub

sub Hiding_StealthX() 
   uo.Useskill('Stealth')
   UO.DeleteJournal() 
   While not UO.InJournal("Voce nao") and not UO.InJournal("You have")
      Wait(500) 
      If UO.InJournal("Voce nao") or UO.InJournal("You have") then 
         uo.say(",exec Hiding_Stealth")
      End If 
   Wend 
End sub



# ------------------------------------ #
# ------- Macroar Blacksmithing ------ #
# ------------------------------------ #

sub BS() 
   var Iron='0x1BEF' 
   uo.Automenu('Blacksmithing','Weapons') 
   uo.Automenu('Weapons','Swords & Blades') 
   uo.Automenu('Swords & Blades','Dagger') 
   repeat 
      uo.DeleteJournal() 
      uo.UseType(Iron) 
      repeat 
         wait(2000) 
         
      until uo.InJournal('You put') or uo.InJournal('Voce errou')
   until (uo.Count(Iron)<=3)
end sub 




# ------------------------------------ #
# - Macroar Inscription (Night Sight)- #
# ------------------------------------ #

sub Inscription() 
   var Scroll='0x0E34'  
   uo.Automenu('Spell Circles','First Circle') 
   uo.Automenu('Spell Circle 1','Magic Arrow') 
   repeat 
      uo.DeleteJournal() 
      uo.useobject("0x0E34")
      uo.UseType(Scroll,"0x0E34") 
      repeat 
         wait(500) 
      until uo.InJournal('You put') or uo.InJournal('Voce errou')
   until (uo.Count(Scroll)<=1)
end sub 



# ------------------------------------ #
# ---- Macroar Tinkering (Springs) --- #
# ------------------------------------ #

sub Tinkering()
   var TK='0x1EBC' 
   var Iron='0x1bef' 
   uo.Automenu('Tinkering','Tools') 
   uo.Automenu('Tools','empty bottle')
   repeat 
      uo.DeleteJournal() 
      uo.UseType(TK) 
      repeat 
         wait(2000) 
      until uo.InJournal('You put') or uo.InJournal('Voce falhou')
   until (uo.Count(Iron)<=1)
end sub 

#-------------------------------------#
#------------Alchemy------------------#
#-------------------------------------#

sub Alchemy()
   var a_mortar_and_pleste='0x0E9B'
   var eyes_of_newt='0x0F87'
   uo.Automenu('What sort of potion do you want to make?','Total Mana Refresh')
   repeat 
      uo.DeleteJournal() 
      uo.UseType(eyes_of_newt) 
      repeat 
         wait(500) 
      until uo.InJournal('You put') or uo.InJournal('Voce falhou em')
   until (uo.Count(eyes_of_newt)<=8)
end sub 

#-------------------------------------#
#------------Alchemy------------------#
#-------------------------------------#

sub AlchemyP()
   var a_mortar_and_pleste='0x0E9B'
   var Nightsade='0x0F88'
   uo.Automenu('What sort of potion do you want to make?','Poison')
   repeat 
      uo.DeleteJournal() 
      uo.UseType(Nightsade) 
      repeat 
         wait(500) 
      until uo.InJournal('You put') or uo.InJournal('Voce falhou em')
   until (uo.Count(Nightsade)<=2)
end sub 


# ------------------------------------ #
# --------- Cure----------- ---------- #
# ------------------------------------ #

sub Cure()
   uo.waittargetself()
   uo.cast('Cure')
endsub

# ------------------------------------ #
# -------------- HEAL----------------- #
# ------------------------------------ #

sub Heal()
   uo.waittargetself()
   uo.cast('Heal')
endsub 

# ------------------------------------ #
# -------------- Great HEAL----------- #
# ------------------------------------ #

sub G.Heal()
   uo.waittargetself()
   uo.cast('Greater Heal')
endsub

# ------------------------------------ #
# --------- Strength------- ---------- #
# ------------------------------------ #

sub Strength()
   uo.waittargetself()
   uo.cast('Strength')
endsub

# ------------------------------------ #
# --------- Reactive Armor- ---------- #
# ------------------------------------ #

sub R.Armor()
   uo.waittargetself()
   uo.cast('Reactive Armor')
endsub


# ------------------------------------ #
# ---------Protection---------------- #
# ------------------------------------ #

sub Protection()
   uo.waittargetself()
   uo.cast('Protection')
endsub

# ------------------------------------ #
# --------- Magic Reflection---------- #
# ------------------------------------ #

sub Reflection()
   uo.waittargetself()
   uo.cast('Magic Reflection')
endsub


# ----------------------------- #
# ---- Ress ------------------- #
# ----------------------------- #

sub Ress()
   
   UO.usetype("0x0E21")
   uo.waittargetground('0x2006') 
end if

endsub




# ----------------------------- #
# ---- Corta ------------------ #
# ----------------------------- #

sub Corta()
   
   uo.waittargetground('0x2006') 
   UO.useobject("0x0F52")
end if

endsub


# ----------------------------- #
# ----------Recall------------- #
# ----------------------------- #

Sub Runebook()
   UO.UseType('0x401A5256') ;
   UO.UseType('0x0F09','0x0482') ; UID e COR de Poção de Invisibility
end sub

sub Runa()
   UO.WaitTargetObject('0x401FD4B1')
   uo.cast('Recall')
endsub

# ----------------------------- #
# ----------LAG---------------- #
# ----------------------------- #

sub ping()
   var a=0
   uo.deletejournal()
   uo.click('backpack')
   repeat
      a=a+1
      wait(1)
   until uo.injournal('backpack')
   uo.serverprint('Ping : '+ STR(( A )*2) + 'ms')
end sub

#-----------------------------------#
#-----------Attack Last-------------#
#-----------------------------------#
Sub att()
   uo.attack('laststatus')
Endsub

#---------Attack Next + MA--------- #
sub attacknext()
   
   var i, m, id 
   DIM t[2] 
   t[0] = "0x0191" 
   t[1] = "0x0190" 
   uo.ignore( "self" ) 
   UO.Set("finddistance","20") 
   for i = 0 to 1 
      uo.findtype( t[i] , -1 , "ground" ) 
      if uo.FindCount() then 
         id = uo.getserial('finditem')
         uo.print('Aim ID '+id)
         uo.attack( "finditem" )
         uo.deletejournal('The spell fizzles.') 
         m = uo.mana
         uo.cast("Magic Arrow","finditem") 
         repeat
            wait(100)
         until uo.injournal('The spell fizzles.') or m > uo.mana
      endif 
   next 
End Sub

#-------------- Passar por cima
Sub Mantleee()
   var x=uo.dex
   if uo.stamina >= x-20 then
      uo.moveitem('0x402263C3','-1','backpack')
      wait(300)
      uo.moveitem('0x400848BE','-1','backpack')
      uo.charprint('0x1152','Pode Passar!')
      wait(1300)
      uo.usetype('0x2684')
      uo.usetype('0x170B')
      uo.usetype('0x170c')
      uo.usetype('0x1F03')
   else
      if uo.stamina <= x-21 then
         uo.msg('.drinkrefresh')
         uo.charprint('0x1152','Pode Passar!')
         wait(1300)
      Endif
   Endif
EndSub

#-------------- Medit com capa -------------
sub medicapa()
   var ser,i
   uo.exec("warmode 0")
   uo.usetype('0x1515')
   uo.useskill('Meditation')
endsub


#-------------------- Cura Alvo

Sub Cura_Alvo()
   var timeout=70
   While True
      UO.WaitTargetObject('Alvo')
      UO.UseType('0x0E21')
      timeout=70
      repeat
         timeout=timeout-1
         wait(100)
      Until UO.InJournal('target|nao precisa|hits|Curou|curou|falhou|fail|errou|cancelada') or timeout<=0
      UO.DeleteJournal()
      wait(1000)
   Wend
EndSub

Sub Cura_Si()
   var timeout=70
   While true
      While UO.Life < UO.Str
         UO.BandageSelf()
         timeout=70
         repeat
            timeout=timeout-1
            wait(100)
         Until UO.InJournal('target|hits|Curou|curou|falhou|fail|errou|cancelada') or timeout<=0
         UO.DeleteJournal()
      Wend
      Wait(1000)
   Wend
EndSub

#-----FazerFS-----


sub fazerFs() 
   dim types[4] 
   var j, key = true 
   types[1] = "0x0F8D" ; ss 
   types[2] = "0x0F8C" ; sa 
   types[3] = "0x0E34" ; blank scroll 
   types[4] = "0x1F5F" ; fs scroll 
   uo.addobject("Bau") 
   while uo.targeting() 
      wait(100) 
   wend 
   while key 
      for j=1 to 3 
         key = pegar(types[j]) 
      next 
      while uo.count(types[1]) > 0 and uo.count(types[2]) > 0 and uo.count(types[3]) > 0 
         uo.usetype('0x0FBF') 
         repeat 
            wait(200) 
         until uo.lastgump( 'replyed' ) == 0 and uo.lastgump( 'text', 4 ) == 'Seventh Circle' 
         uo.LClick(325,443) 
         uo.deletejournal() 
         j=0 
         repeat 
            wait(200) 
            j=j+1 
         until uo.injournal("Voce") or j > 30 
      wend 
      for j=1 to 4 
         guardar(types[j]) 
      next 
   wend 
endsub 




#------------ Fecha Gate Proximo
Sub gatef()
   UO.Set('finddistance','14')
   uo.findtype("0x0F6C","-1","ground")
   if uo.findcount()>0 then
      UO.cast('Dispel','finditem')
      #	wait(10)
      # uo.charprint('0x0000', '3 segundos');
      # wait(1000)
      # uo.charprint('0x0000', '2 Segundos');
      # wait(1000)
      # uo.charprint('0x0000', '1 Segundo!');
      # wait(1060)
      # uo.charprint('0x0000', 'Gate FECHADO!');
   endif
   if uo.findcount()==0 then
      uo.print('Nenhum gate encontrado!')
   endif 
   UO.Set('finddistance','14')
end sub
#------------Magias scrols / book -------------


sub Poison() 
   UO.WaitTargetLast()
   If UO.Count('0x1F40')>0 then
      UO.UseType('0x1F40')
   Else
      UO.Cast('Poison')
   else 
   Endif
endsub


sub EnergyBolt()                                 
   UO.WaitTargetLast()
   UO.Cast('Energy Bolt')
endsub


sub FlameStrike()
   UO.WaitTargetLast()
   If UO.Count('0x1F5F')>0 then
      UO.UseType('0x1F5F')
   Else
   End If
   #wait(10)
   #uo.charprint('0x0099', '3 segundos');
   #wait(1000)
   #uo.charprint('0x0099', '2');
   #wait(1000)
   #uo.charprint('0x0099', '1!');
   #wait(1090)
   #uo.charprint('0x0099', '!! Flame Strike !!');
endsub

sub cure()
   UO.WaitTargetSelf()
   If UO.Count('0x1F37')>0 then
      UO.UseType('0x1F37')
   Else
      UO.Cast('Cure')
   End If
   wait(500) 
endsub

sub magiki()                                 
   UO.Cast('Magic Arrow')
endsub

sub Paralyze()
   uo.cast('Paralyze','lasttarget')
   wait(500)
endsub 


sub magic_reflect()
   uo.cast('Magic Reflect')
   uo.waittargetself()
   wait(500)
endsub

sub bless()
   uo.cast('Bless')
   uo.waittargetself()
   wait(500)
endsub


sub Reactive()
   uo.cast('Reactive Armor')
   uo.waittargetself()
   wait(500)
   
sub dispels()
   uo.cast('Dispel')
   uo.waittargetself()   
endsub 

sub protection2()
   uo.cast('Protection')
   uo.waittargetself()
   wait(500)
   
   #-----------Ressurrection
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

#---- Equipar Arma e Shield ----#

sub arm2()
   uo.attack('alvo')
   uo.useobject('arma')
   wait(10)
   uo.useobject('shield')
end sub

#++++++++++-= Mostrar PING =-+++++++++++++++
sub getlag()
   var a=0
   uo.deletejournal()
   uo.click('backpack')
   repeat
      a=a+1
      wait(1)
   until uo.injournal('backpack')
   uo.serverprint('Ping: '+ STR(A*1) + '')
end sub

#++++++++++-= Tracking Players =-+++++++++++++++
sub track()
   While UO.SkillVal( 'Tracking' ) < 1028
      UO.CancelMenu()
      UO.AutoMenu('Tracking','Monsters')
      UO.useskill('Tracking')
      wait(3500)
   wend
endsub


; Stroller Script
# ------------------

sub main()
   UO.fontcolor('0x005d') ; Nao meche
end sub

# ------------------

Sub Runebook()
   UO.UseType('0x0EFA') ;
   UO.UseType('0x0F0E','0x011B') ; UID e COR de Poção de Invisibility
end sub
# --------------
Sub Armar()
   UO.UseType('0x1B76') ; UID de Heater Shield
   UO.UseType('0x13B9') ; UID de Espada
endsub

# ------------------------------------

sub armdms()
   UO.UseType('0x1412') ;
   UO.UseType('0x1B76') ; UID de Heater Shield
   uo.usetype("0x0F51")
   uo.usetype("0x13FC")
   UO.UseType('0x13B9')
   UO.UseType('0x143E')
   uo.usetype("0x13B9")
   uo.usetype("0x1B76")
   uo.usetype("0x1406")
   uo.usetype("0x0F4B")
   uo.usetype("0x13FE")
   uo.usetype("0x0F4D")
   uo.usetype("0x1400")
   uo.usetype("0x0F49")
   uo.usetype("0x0DF0")
   uo.usetype("0x0F45")
   uo.usetype("0x0DF1")
   uo.usetype("0x0F47")
   uo.usetype("0x13AF")
   uo.usetype("0x1440")
   uo.usetype("0x1402")
   uo.usetype("0x0F5E")
   uo.usetype("0x1404")
   UO.WaitTargetLast() ; Last Target
end sub

# ------------------

sub Despir()
   UO.Undress() ; Despir tudo
endsub

# ------------------

sub Vestir()
   UO.UseType('0x1416') ; UID de itens
   UO.UseType('0x1417') ; UID de itens
   UO.UseType('0x1541') ; UID de itens
   UO.UseType('0x1547') ; Deer Mask
   UO.UseType('0x1545') ; UID de itens
   UO.UseType('0x1411') ; Legs
   UO.UseType('0x1414') ; Gloves
   UO.UseType('0x1413') ; Gorget
   UO.UseType('0x204E') ; UID de itens
   UO.UseType('0x1410') ; Arms
   UO.UseType('0x1415') ; Chest
   UO.UseType('0x170D') ; UID de itens
   UO.UseType('0x141A') ; UID de itens
   UO.UseType('0x1418') ; UID de itens
   UO.UseType('0x2684') ; Death Shroud
   uo.say('GriTa PrOnTo !')
endsub

# ------------------

sub gaterapido()
   uo.exec("warmode 0")
   uo.waittargettype('0x1F14')
   uo.cast('Gate Travel')
endsub

# ------------------

sub recallrapido()
   uo.exec("warmode 0")
   uo.waittargettype('0x1F14')
   uo.cast('Recall')
   #wait(10)
   #uo.charprint('0x0099', '4 segundos');
   #wait(1050)
   #uo.charprint('0x0099', '3 segundos');
   #wait(1060)
   #uo.charprint('0x0099', '2 segundos');
   #wait(1070)
   #uo.charprint('0x0099', '1 segundo');
   #wait(1100)
   #uo.charprint('0x0099', 'Recall!');
   
endsub

# -----------------

sub Bandagem()
   UO.BandageSelf() ; Bandage Self
endsub

# ------------------

sub Bandress()
   UO.UseType('0x0E21','0x0000') ; UID e COR de bandagem limpa (pra ressar)
endsub

# ------------------

sub Invis()
   UO.UseType('0x0F0E','0x011B') ; UID e COR de Poção de Invisibility
endsub

# ------------------

sub Refresh()
   UO.UseType('0x0F0E','0x0012') ; UID e COR de Refresh
endsub

# ------------------
sub FS()
   UO.WaitTargetLast() ; Last Target
   UO.UseType('0x1F5F','0x0000') ; UID e Cor de Scroll de Flame Strike
endsub
# ------------------

sub EB()
   UO.WaitTargetLast() ; Last Target
   UO.UseType('0x1F56','0x0000') ; UID e Cor de Scroll de Energy Bolt
endsub

# ------------------

sub Paralyze()
   UO.WaitTargetLast() ; Last Target
   UO.Cast('Paralyze') ; Magia Paralyze
endsub

# ------------------

sub Poison()
   UO.WaitTargetLast() ; Last Target
   UO.Cast('Poison') ; Magia Poison
endsub

# ------------------

sub Raio()
   UO.WaitTargetLast() ; Last Target
   UO.Cast('Lightning') ; Magia Light
endsub

# ------------------

sub Clumsy()
   UO.WaitTargetLast() ; Last Target
   UO.Cast('Clumsy') ; Magia Clumsy
endsub

# ------------------

sub Explosion()
   uo.waittargettype('0x0F02', '0x0000')# Type,Color Lesser Explosion
   uo.cast('Magic Arrow')
   if uo.count('0x0F02','0x0000') <= 0 then
      uo.waittargetself()
      uo.cast('Dispel')
   end if
endsub

# ------------------

sub Cure()
   UO.WaitTargetSelf()
   UO.Cast('Cure')
endsub


# ------------------

sub Reflection()
   UO.WaitTargetSelf()
   UO.Cast('Magic Reflection')
endsub


#----------------------------------------------
sub lc() ; LIMPA CHÃO
   var i,n
   Dim A[23]
   A[1] = 0x0EED ;GOLD
   A[2] = 0x0EED ;GOLD
   A[3] = 0x0EED ;GOLD
   A[4] = 0x0EED ;GOLD
   A[5] = 0x0EED ;GOLD
   A[6] = 0x0EED ;GOLD
   A[7] = 0x0EED ;GOLD
   A[8] = 0x0EED ;GOLD
   A[9] = 0x0EED ;GOLD
   A[10] = 0x0EED ;GOLD
   A[11] = 0x0EED ;GOLD
   A[12] = 0x0EED ;GOLD
   A[13] = 0x0EED ;GOLD
   A[14] = 0x0EED ;GOLD
   A[15] = 0x0EED ;GOLD
   A[16] = 0x0EED ;GOLD
   A[17] = 0x0EED ;GOLD
   A[18] = 0x0EED ;GOLD
   A[19] = 0x0EED ;GOLD
   A[20] = 0x0EED ;GOLD
   A[21] = 0x0EED ;GOLD
   A[22] = 0x0EED ;GOLD
   A[23] = 0x0EED ;GOLD
   i = 1400
   FOR n=1 TO 23
      uo.findtype(A[n],"-1","ground")
      if uo.findcount() > 0 then
         UO.grab(0,"finditem")
         Wait(i)
      end if
   NEXT
end sub

#-------------------

sub corta_corpo()
   uo.useobject('cortar')
   uo.waittargetground('0x2006')
endif
next
uo.exec('exec corpo')
end sub

# ------------------

#-------------------------

# ------------------------------------ #
# ------------ Disarmar -------------- #
# ------------------------------------ #

sub Disarm()
   uo.msg('.disarm')  
end sub

# ------------------------------------ #
# ----- Magia de Cura + Bandagem ----- #
# ------------------------------------ #

sub Cure_Bands()
   uo.waittargetself()
   uo.cast('Cure')
   wait(2500)
   uo.waittargetself()
   uo.usetype('0x0E21')
end sub

#-------- Ataque de Scroll de FS c/ Last Target

sub war()
   UO.WaitTargetLast() ; Last Target
   UO.UseType('0x1F5F') ; UID Scroll de Flame Strike
endsub


#-------------------------------------------------

sub Army()
   UO.UseType('0x0F49') ;
   UO.UseType('0x0F47') ;
endsub

#---------------------------------------------------------
sub HorseStop()
   if UO.ObjAtLayer('Horse') then
      UO.UseObject('self')
      wait(100)
      UO.Msg('all stop')
   else
      UO.UseObject('Horse')
   end if
end sub
#---------------------------------------------------------
sub Horsekill()
   If UO.ObjAtLayer('Horse') Then
      UO.UseObject('self')
      uo.waittargetobject('lasttarget')   
      uo.waittargetobject('laststatus')   
      uo.msg('all kill')
end sub
#------------------------------------------------
sub Stealth()
   uo.exec("warmode 0")
   Uo.UseSkill('Hiding')
end sub
#------------------------------------------------------------

sub block2() ; dropar wood
   UO.waittargettype('0x1b9b')
   UO.drop()
end sub

#----------------------------------------------------------

sub block() ; dropar wood
   VAR wood = '0x1b9b'
   UO.waittargettype( wood )
   UO.drop(1,str(uo.getx("self")),str(uo.gety("self")),str(uo.getz("self")))
end sub

#-----------------------------------------------------------

sub soltar3() ; puxar wood
   UO.findtype('0x1b9b','0x0000','ground')
   UO.grab(0,"finditem")
end sub

#----------------------------------------------------------

sub soltar2() ; puxar wood
   UO.findtype('0x1b9b',"-1","ground")
   UO.grab(0,"finditem")
end sub

#------------------------------------------------------------
sub cercar() ; Cerca o Player com WOODS, em todos os lados
   VAR wood = '0x1b9b'
   UO.Set('lasttarget','laststatus')
   UO.findtype('wood',-1,'backpack')
   if UO.count(wood)>=4 then
      UO.waittargettype( wood )
      
      UO.drop(1,str(uo.getx("lasttarget")-1),str(uo.gety("lasttarget")),str(uo.getz("lasttarget")))
      wait(600)
      UO.waittargettype( wood )
      
      UO.drop(1,str(uo.getx("lasttarget")),str(uo.gety("lasttarget")+1),str(uo.getz("lasttarget")))
      wait(600)
      UO.waittargettype( wood )
      
      UO.drop(1,str(uo.getx("lasttarget")),str(uo.gety("lasttarget")-1),str(uo.getz("lasttarget")))
      wait(600)
      UO.waittargettype( wood )
      
      UO.drop(1,str(uo.getx("lasttarget")+1),str(uo.gety("lasttarget")),str(uo.getz("lasttarget")))
   else
      UO.findtype('wood',-1,'backpack')
      UO.print(UO.GetNAME('self') + " para realizar essa acao precisa-se de 4 
      woods no minimo, voce possui: " +Str(UO.Count( wood ))+ ' WOODS')
   endif
end sub

#----------------------------------------------------------

sub blockwall() ; Quando estiver em "X" esse macro blockeia as áreas 
   ;desturbaveis, fazendo com q vc use teleporte sem ser disturbado
   VAR wood = '0x1b9b'
   UO.Set('lasttarget','laststatus')
   UO.findtype('wood',-1,'backpack')
   if UO.count(wood)>=4 then
      UO.waittargettype( wood )
      
      UO.drop(1,str(uo.getx("self")-1),str(uo.gety("self")+1),str(uo.getz("self")))
      wait(600)
      UO.waittargettype( wood )
      
      UO.drop(1,str(uo.getx("self")+1),str(uo.gety("self")+1),str(uo.getz("self")))
      wait(600)
      UO.waittargettype( wood )
      
      UO.drop(1,str(uo.getx("self")+1),str(uo.gety("self")-1),str(uo.getz("self")+1))
      
      UO.waittargettile(400,str(uo.getx("self")-1),str(uo.gety("self")-1),str(uo.getz("self")))
      UO.cast('Teleport')
   else
      UO.findtype('wood',-1,'backpack')
      UO.print(UO.GetNAME('self') + " para realizar essa acao precisa-se de 4 
      woods no minimo, voce possui: " +Str(UO.Count( wood ))+ ' WOODS')
   endif
end sub

sub travar_dog()
   uo.UseType('0x211C') ;
   uo.UseType('0x2121') ;
   uo.UseType('0x2124') ;
   uo.say('All Stop')
end sub

#----------------------------------------------------------
sub sword()
   uo.bandageself()
   wait(250)
   uo.usetype(0x1419)
   uo.usetype(0x1412)
   uo.usetype(0x1B76)
   uo.usetype(0x1B77)
   uo.waittargetself()
   uo.usetype(0x13B9)
end sub


sub Magia_WS_LT() 
   
   uo.deletejournal() 
   uo.cast("Wall of Stone","laststatus") 
   while not uo.injournal('In Sanct Ylem') and not uo.injournal('Targeting 
      cancelled') and not uo.injournal('line of sight') 
      wait(100) 
   wend 
   if uo.injournal('Targeting canceled') or uo.injournal('linha de visao') then 
      uo.print("MAGIA CANCELADA") 
   else 
      wait(300) 
      uo.print("Faltam 2 Segundos") 
      wait(1000) 
      uo.print("Faltam 1 Segundo") 
      wait(1000) 
      uo.print("CONCLUIDO!") 
   end if 
   
endsub
#------------------------------------------
sub armaescudo() 
   uo.waittargetobject('lasttarget')
   UO.UseObject('arma') ; UID de itens
   UO.UseObject('escudo') ; UID de itens
   uo.attack('laststatus')
end sub
#------------------------------------------
sub st() 
   #################### 
   #aaoi?:CONDOMchick # 
   #################### 
   
   uo.deletejournal() 
   VAR x1,x2,y1,y2,sx,sy,limit 
   
   x1=0 
   x2=0 
   y1=0 
   y2=0 
   
   uo.Set('finddistance','8') 
   na: 
   uo.findtype('0x0080',-1,'ground') 
   if uo.findcount()>0 then 
      sx=str(uo.getx('finditem')) 
      sy=str(uo.gety('finditem')) 
      if x1==1 and x2==1 or y1==1 and y2==1 then 
         GOTO pox 
      endif 
      if sx==str(uo.getx('laststatus')+1) and sy==str(uo.gety('laststatus')) then 
         x1=1 
      endif 
      
      if sx==str(uo.getx('laststatus')-1) and sy==str(uo.gety('laststatus')) then 
         x2=1 
      endif 
      
      if sx==str(uo.getx('laststatus')) and sy==str(uo.gety('laststatus')+1) then 
         y1=1 
      endif 
      
      if sx==str(uo.getx('laststatus')) and sy==str(uo.gety('laststatus')-1) then 
         y2=1 
      endif 
      
      uo.ignore('finditem') 
      GoTo na 
   endif 
   
   pox: 
   uo.ignorereset() 
   
   uo.print(str(x1)+str(x2)+str(y1) + str(y2)) 
   if x1==0 and x2==0 and y1==0 and y2==0 then 
      
      uo.waittargettile("400",str(uo.getx('laststatus')),str(uo.gety('laststatus')),str(uo.getz('laststatus'))) 
      uo.cast("Wall of Stone") 
   endif 
   if y1==1 and y2==1 then 
      
      if str(uo.getx())>str(uo.getx('laststatus')) then 
         uo.waittargettile("400",str(uo.getx('laststatus')+1),str(uo.gety('laststatus')),str(uo.getz('laststatus'))) 
         uo.cast("Wall of Stone") 
      else 
         uo.waittargettile("400",str(uo.getx('laststatus')-1),str(uo.gety('laststatus')),str(uo.getz('laststatus'))) 
         uo.cast("Wall of Stone") 
      endif 
   endif 
   
   if x1==1 and x2==1 then 
      
      if str(uo.gety())>str(uo.gety('laststatus')) then 
         uo.waittargettile("400",str(uo.getx('laststatus')),str(uo.gety('laststatus')+1),str(uo.getz('laststatus'))) 
         uo.cast("Wall of Stone") 
      else 
         uo.waittargettile("400",str(uo.getx('laststatus')),str(uo.gety('laststatus')-1),str(uo.getz('laststatus'))) 
         uo.cast("Wall of Stone") 
      endif 
   endif 
   limit=0 
   #or not uo.injournal('Target is not') or not uo.injournal('sufficient mana') 
   while not uo.injournal('In Sanct Ylem') 
      wait(100) 
      limit=limit+1 
      if limit==100 then 
         goto end 
      endif 
   wend 
   end: 
end sub
#----------------------------------
sub IgnoreLast(Name) # Functions looks if last target had a name=Name and ignores it then.
   if (UO.GetName('lasttarget')==Name) then
      UO.Ignore('lasttarget')
      return 1 # Return 1 if we ignored someone
   end if
   return 0
end sub

sub targetfilter() 
   var IgCnt=0 ; //Ignore count
   uo.press (123) ; target next key 
   
   IgCnt=IgCnt+IgnoreLast('carlos I') # Counting ignored people
   IgCnt=IgCnt+IgnoreLast('PrOoF') # Counting ignored people
   IgCnt=IgCnt+IgnoreLast('Yusuf') # Counting ignored people
   
   if (IgCnt>0) then ## Means that we ignored someone
      UO.exec('exec targetfilter') ## Running this function again without deleting ignore list
      return 
   end if
   
   UO.IgnoreReset() ## If target is locked than delete ignorelist, why do we need it if we've found a target?
end sub
#---------------------------------------
sub Magic_Arrow_lastt()
   UO.WaitTargetLast() ; Last Target
   uo.cast('Magic Arrow')
endsub
sub Murar_Lt() 
   UO.WaitTargetLast() ; Last Target
   uo.cast('Wall of Stone')
end sub
sub clusm()
   UO.WaitTargetLast() ; Last Target
   uo.cast('Clumsy')
endsub
sub Flame_Strike()
   UO.WaitTargetLast() ; Last Target
   uo.cast('Flame Strike')
endsub
sub Paralyze()
   UO.WaitTargetLast() ; Last Target
   uo.cast('Paralyze')
endsub
sub Poison()
   UO.WaitTargetLast() ; Last Target
   uo.cast('Poison')
endsub
sub Lightning()
   UO.WaitTargetLast() ; Last Target
   uo.cast('Lightning')
endsub
sub Fire_Field()
   UO.WaitTargetLast() ; Last Target
   uo.cast('Fire Field')
endsub
sub Paralyze_fild()
   UO.WaitTargetLast() ; Last Target
   uo.cast('Paralyze Field')
endsub
sub Wall_of_Stone_lt()
   UO.WaitTargetLast() ; Last Target
   uo.cast('Wall of Stone')
endsub
sub Wall_of_Stone()
   uo.cast('Wall of Stone')
endsub
sub Magic_Arrow_LT()
   UO.WaitTargetLast() ; Last Target
   uo.cast('Magic Arrow')
endsub
sub Harm()
   UO.WaitTargetLast() ; Last Target
   uo.cast('Harm')
endsub
sub Weaken()
   UO.WaitTargetLast() ; Last Target
   uo.cast('Weaken')
endsub
#------------
sub Magia_Heal_Amigo1() 
   
   uo.cast("Greater Heal","Amigo1") 
   
end sub
#-------------------
sub Magia_Heal_Amigo2() 
   
   uo.cast("Greater Heal","Amigo2") 
   
end sub
#-------------------
sub Arrow_Amigo1() 
   
   uo.cast("Magic Arrow","Amigo1") 
   
end sub
#-------------------
sub Arrow_Amigo2() 
   
   uo.cast("Magic Arrow","Amigo2") 
   
end sub

#----------------------
sub autostart()
   uo.setseason(2); set summer season
end sub

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

Sub recall()
   uo.warmode(0)
   UO.exec('recall 0x400460e2 2')
   Wait(100)
   UO.useskill('Stealth')
   Wait(2800)
end sub

sub gatear()
   Uo.Useobject('0x400B5AF3')
   wait(150)
   Uo.LClick(726,339)
endsub

Sub Mount()
   If UO.ObjAtLayer('Horse') Then
      UO.UseObject('self')
      UO.Msg('All Stay')
   Else
      UO.Msg('All Come')
      UO.UseObject('pet')
   End If
End Sub

#---------ress
sub Ress()
   var i 
   Dim a[2] 
   a[1] = '0x0192' 
   a[2] = '0x0193' 
   UO.Set('finddistance','2') 
   For i= 1 to 2 
      uo.findtype(a[i], -1, 'ground') 
      if uo.findcount() then 
         uo.waittargetobject('finditem') 
         uo.usetype('0x0E21')
         #uo.cast('Resurrection') ; ress
      else 
         uo.print('ghost not found') 
      end if 
   Next 
end sub

sub usebands()
   if uo.poisoned('self') then
      uo.cast('Cure','self')
   else
      if uo.life<uo.str and uo.count('0x0E21') then
         uo.bandageself()
      endif
   endif
   uo.charprint('0x1152',uo.count('0x0E21'))
endsub

sub openbank()
   uo.set('finddistance','4')
   uo.findtype('0x0BD2','-1','ground')
   if uo.findcount() > 0 then
      uo.recall('finditem','6')
   endif
end sub

sub pf() ; PF EMBAIXO DE VC
   Uo.waittargettile("400",str(Uo.getx("self")),str(Uo.gety("self")),str(Uo.getz("self"))) 
   uo.cast('Paralyze Field')
   wait(2000)
end sub

sub pf2(); PF NO TARGET DO OPONENTE
   Uo.waittargettile("400",str(Uo.getx("lasttarget")),str(Uo.gety("lasttarget")),str(Uo.getz("lasttarget")))
   uo.cast('Paralyze Field')
end sub

sub gate()
   Uo.Useobject('0x4014D4B6')
   wait(170)
   Uo.LClick(349,213)
   wait(10)
   Uo.LClick(349,213)
   UO.useskill('Hiding')
   Wait(2800)
endsub

sub aceitarress()
   Uo.LClick(330,238)
endsub

sub msg()
   uo.fontcolor(6)
   uo.msg('UAsAhsUAHsUAHUAHS')
   wait(100)
   uo.fontcolor(66)
   uo.msg('UAhsUHSushUSHAUSH')
end sub

sub buffs()
   uo.cast('Reactive Armor','self')
   wait(2500)
   uo.cast('Protection','self')
   wait(2500)
   uo.cast('Magic Reflection','self')
   wait(4000)
   uo.cast('Strength','self')
end sub

sub Equip()
   ;uo.fontcolor(UO.Random(100))
   ;uo.msg('Hora de Morfar!')
   uo.usetype('0x1415'); Peito
   ;uo.say('Peito')
   ;wait(500)
   uo.usetype('0x1411'); Perna
   ;uo.say('Perna')
   ;wait(500)
   uo.usetype('0x1410'); Braco
   ;uo.say('Braço')
   ;wait(500)
   uo.usetype('0x1414'); Mao
   ;uo.say('Mão')
   ;wait(500)
   uo.usetype('0x1413'); Pescoco
   ;uo.say('Pescoço')
   ;wait(500)
   uo.usetype('0x1412'); Cabeca	
   ;uo.say('Cabeça')
   ;wait(500)
   uo.usetype('0x170B'); Bota
   ;uo.say('Bota')
   ;wait(500)
   uo.usetype('0x153B'); Half Apron
   ;uo.say('Half')
   ;wait(500)
   uo.usetype('0x1541'); Sash	
   ;uo.say('Sash')
   ;wait(500)
   uo.usetype('0x108A'); Anel	
   ;uo.say('Anel')
   ;wait(500)	
   uo.usetype('0x1515'); Capa
   ;uo.say('Capa')
   ;wait(500)
   uo.usetype('0x2684'); Mantle
   uo.usetype('0x1f03'); Robe
   ;uo.say('Robe')
   ;wait(500)
   ;uo.fontcolor(UO.Random(100))
   ;uo.msg('Morfagem Completa!')	
endsub


sub fsscrollll()
   if uo.count("0x1F56")>0 then
      uo.waittargetlast()
      uo.useType("0x1F56")
   else
      uo.waittargetlast()
      uo.cast("Energy Bolt")
   endif
end sub

sub stealth()
   ################# Configurações
   var type='0x1415' #Type torso
   var type2='0x1711' #Type legs
   #################
   UO.DeleteJournal()
   var ser,i
   var passos=18
   var x
   var x2
   var y
   var y2
   var caststeal=0
   
   DIM parte[2]
   parte[1] = "Torso"
   parte[2] = "Pants"
   for i = 1 to 2
      if parte[i] <> "Nulo" then
         if uo.ObjAtLayer(parte[i]) then
            ser = uo.getserial(uo.ObjAtLayer(parte[i]))
            repeat
               uo.moveitem(ser,'-1','backpack')
               wait(10)
            until NOT UO.ObjAtLayer(parte[i])
         endif
      endif
   next
   
   while not uo.hidden()
      repeat
         if caststeal==0 then
            uo.useskill('Stealth')
            caststeal=1
            UO.DeleteJournal()
         endif
         wait(100)
         if uo.injournal('preocupado') then
            uo.warmode(0)
            caststeal=0
            UO.DeleteJournal()
         endif
      Until uo.injournal('ficou') or uo.injournal('cancelada') or uo.injournal('sua tentativa') or uo.injournal('esperar')
      if uo.injournal('cancelada') or uo.injournal('sua tentativa') or uo.injournal('esperar') then
         caststeal=0
         UO.DeleteJournal()
      endif
      if uo.injournal('comeca a') or uo.injournal('ficou') then
         x=uo.getx()
         y=uo.gety()
      endif
   wend
   while uo.hidden()
      wait(50)
      x2=uo.getx()
      y2=uo.gety()
      if not (x==x2 and y==y2) then
         passos=passos-1
         if not passos<0 then
            uo.charprint('0x0043','Passos restando:',passos)
         endif
         x=uo.getx()
         y=uo.gety()
      endif
   wend
   uo.usetype(0x1411)
   wait(10)
   uo.usetype(0x1415)
   wait(10)
   uo.usetype(0x1416)
   wait(10)
   uo.usetype(0x141A)
endsub

sub Armas()
   uo.waittargetobject('lasttarget')
   uo.useobject('a2')
   uo.attack ('laststatus')
   uo.attack ('lasttarget') 
endsub


sub Arcos()
   #Feito por Meian
   var i
   dim arco[10]
   arco[1] =0x13B1 ; Bow 1
   arco[2] =0x13B2 ; Bow 2
   arco[3] =0x0F4F ; CrossBow 1
   arco[4] =0x0F50 ; CrossBow 2
   arco[5] =0x13FC ; HeavyCrossbow 1
   arco[6] =0x13FD ; HeavyCrossbow 2
   arco[7] =0x26C2 ; CompositeBow 1
   arco[8] =0x26CC ; CompositeBow 2
   arco[9] =0x26C3 ; RepeatingCrossBow 1
   arco[10] =0x26CD ; RepeatingCrossBow 2
   for i = 1 to 10
      if uo.count(arco[i])>=1 then
         uo.usetype(arco[i])
         wait(150)
      endif
   next
endsub

sub corta_corpo1()
   uo.set('finddistance','3')
   wait(100)
   uo.findtype('0x2006','-1','ground')
   if uo.findcount() then
      uo.waittargetobject('finditem')
      uo.useobject('cortar')
      wait(250)
      uo.msg('.disarm')
   end if
end sub

sub cutbody()
   var x
   var body = '0x2006'
   uo.set('finddistance','3')
   uo.findtype(body, '-1', 'ground')
   if uo.findcount() == 0 then
      UO.CharPrint('self',0x6, "Nenhum corpo encontrado")
      uo.ignorereset()
   else 
      uo.waittargetobject('finditem')
      uo.useobject('cortar')           
   end if  
   wait(100)
   uo.disarm()   
end sub

sub corpo()
   var loop
   DIM BoneCorpse[9]
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
   next
   uo.exec('exec looternew')
End Sub


var typePlaca='0x0BD2'

Sub guardaloot()
   ###################
   # Feito Por Meian #
   # Banco by DracoX #
   ###################
   var placa='0x00000000'
   UO.IgnoreReset()
   UO.Set('finddistance',5)
   UO.FindType(typePlaca,'-1','ground')
   While UO.FindCount()>0
      If UO.GetDistance('finditem')<UO.GetDistance(placa) Or placa=='0x00000000' Then
         placa=UO.GetSerial('finditem')
      End If
      UO.Ignore('finditem')
      UO.FindType(typePlaca,'-1','ground')
   WEnd
   If placa=='0x00000000' Then
      If UO.GetNotoriety('self')<=1 Then
         UO.Msg('Bank $ Buy $ Guards')
      Else
         UO.Msg('Bank $ Buy')
      End If
   Else
      UO.UseObject(placa)
      Wait(800)
      UO.LClick(315,440)
   End If
   UO.IgnoreReset()
   uo.print('Selecione a bag para guardar o loot') ###Tirar ; se desejar setar bag toda vez q utilizar o macro
   uo.addobject('BagDeLoot')
   while uo.targeting()
      wait(100)
   wend
   wait(100) ###Tirar ; se desejar setar bag toda vez q utilizar o macro
   var i
   DIM Loot[21]
   Loot[1] = 0x1415 ; Chest
   Loot[2] = 0x1416 ; Chest 2
   Loot[3] = 0x1411 ; Legs
   Loot[4] = 0x141A ; Legs 2
   Loot[5] = 0x1414 ; Gloves
   Loot[6] = 0x1418 ; Gloves 2
   Loot[7] = 0x1413 ; Gorget
   Loot[8] = 0x1410 ; Arms
   Loot[9] = 0x1417 ; Arms 2
   Loot[10] = 0x1412 ; Helmet
   Loot[11] = 0x1419 ; Helmet 2
   Loot[12] = 0x1b76 ; Heater Shield
   Loot[13] = 0x1b77 ; Heater Shield 2
   Loot[14] = 0x1bc3 ; Chaos Shield
   Loot[15] = 0x1bc4 ; Order Shield
   Loot[16] = 0x1bc5 ; Order Shield 2
   Loot[17] = 0x1530 ; Cape Medit
   Loot[18] = 0x1515 ; Cape Medit 2
   Loot[19] = 0x1541 ; Sash Str
   Loot[20] = 0x1542 ; Sash Str 2
   Loot[21] = 0x108A ; Ring Of Force
   for i=1 to 21
      while Uo.Count(Loot[i]) >= 1 
         UO.FindType(Loot[i],-1,'backpack')
         UO.MoveItem('finditem','0','BagDeLoot')
         wait(600)
      Wend
   next
   uo.print('Loot Guardado!!')
   uo.print('!!FIGHT!!')
End Sub

sub bomba2()
   uo.waittargettype('0x0F02','')
   uo.cast('Clumsy')
end sub
sub bomba()
   uo.waittargettype('0x0F02', '0x0000')# Type,Color Lesser Explosion
   uo.cast('Clumsy')
   if uo.count('0x0F02','0x0000') <= 0 then
      uo.waittargetself()
      uo.cast('Dispel')
   end if
end sub

#-------------------------------------------------------
Sub Montaria()
   If UO.ObjAtLayer('Horse') Then
      UO.UseObject('self')
      UO.Msg('All Stay')
   Else
      UO.Msg('All ComE')
      UO.UseObject('Pet')
   End If
End Sub

#-----------------------------
sub fsscroll()
   if uo.count("0x1F56")>0 then
      uo.waittargetlast()
      uo.useType("0x1F56")
   else
      if uo.count("0x1F5F")>0 then
         uo.waittargetlast()
         uo.useType("0x1F5F")
      else
         uo.waittargetlast()
         uo.cast("Energy Bolt")
      endif
   endif
endif
end sub

#------------------------------
sub PF_self(); PF EMBAIXO DE VC
   Uo.waittargettile("400",str(Uo.getx("self")),str(Uo.gety("self")),str(Uo.getz("self")))
   uo.cast('Paralyze Field')
   wait(2000)
   uo.waittargetself()
   uo.usetype('0x0F0D','0x0021')
end sub

sub PF_fourtileback(); PF EMBAIXO DE VC
   Uo.waittargettile("400",str(Uo.getx("self")),str(Uo.gety("self")),str(Uo.getz("self")))
   uo.cast('Paralyze Field')
   wait(2000)
   uo.waittargetself()
   uo.usetype('0x0F0D','0x0021')
end sub

#--------------------------------
sub NextTarget()
   wait(150)
   UO.Set('lasttarget','laststatus')
end sub

# Atacar com Scroll / Livro ----
sub scroll()
   if uo.count("0x1F56")>0 then
      uo.waittargetlast()
      uo.useType("0x1F56")
   else 
      if uo.count("0x1F5F")>0 then
         uo.waittargetlast()
         uo.useType("0x1F5F")
      else 
         uo.waittargetlast()
         uo.cast("Energy Bolt")
      endif
   endif
endif
end sub

#-----------------------------------
sub Armas1()
   uo.waittargetobject('lasttarget')
   uo.useobject('a1')
   uo.attack ('lasttarget') 
   uo.attack ('laststatus')    
endsub


#+++++++++++++-= Auto Attack all players =-+++++++++++++++
sub StartAttack1()
   StartAttack(1)
end sub
#++++++++++-= Auto Attack PK players only =-+++++++++++++++
sub StartAttack0()
   StartAttack(0)
end sub

sub StartAttack(status)
   UO.Ignore("self")
   Var FindOK=false,temp,mess,t=0,k,a
   DIM Friend[29]
   VAR endlist=23
   Friend[1]="MondainTheWizard"
   Friend[2]=""
   Friend[3]=""
   Friend[4]=""
   Friend[5]=""
   Friend[6]=""
   Friend[7]=""
   Friend[8]=""
   Friend[9]=""
   Friend[10]=""
   Friend[11]=""
   Friend[12]=""
   Friend[13]=""
   Friend[14]=""
   Friend[15]=""
   Friend[16]=""
   Friend[17]=""
   Friend[18]=""
   Friend[19]=""
   Friend[20]=""
   Friend[21]=""
   Friend[22]=""
   Friend[23]=""
   Friend[24]="COLOQUE AQUI UM AMIGO"
   Friend[25]="COLOQUE AQUI UM AMIGO"
   Friend[26]="COLOQUE AQUI UM AMIGO"
   Friend[27]="COLOQUE AQUI UM AMIGO"
   Friend[28]="COLOQUE AQUI UM AMIGO"
   Friend[29]="COLOQUE AQUI UM AMIGO"
   uo.set('finddistance','23')
   for t=0 to 29
      repeat
         uo.findtype("0x019"+str(t),"-1","ground")
         temp=0
         for k=0 to endlist
            if Uo.GetName("finditem")==Friend[k] and uo.findcount()<>0 then
               UO.Ignore("finditem")
               k=endlist
               temp=1
            end if
         next
         if temp==0 and uo.findcount()<>0 then
            if status==0 and uo.getnotoriety("finditem")>2 then
               UO.addobject('Enemy',uo.getserial("finditem"))
               uo.attack( "finditem" )
               uo.cast("Magic Arrow","finditem")
               
               uo.set('lasttarget','finditem')
               return
            else
               if status==1 then
                  UO.addobject('Enemy',uo.getserial("finditem"))
                  uo.attack( "finditem" )
                  uo.cast("Magic Arrow","finditem")
                  uo.set('lasttarget','finditem')
                  return
               else
                  uo.ignore("finditem")
               end if
            end if
         end if
      until uo.findcount()==0
      if uo.findcount()==0 then
         UO.IgnoreReset()
      end if
   next
end sub

#++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
#++++++++++++++-= Auto Attack Men\Women =-++++++++++++++++ 
#++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 

#+++++++++++++-= Auto Attack all players =-+++++++++++++++ 
sub StartAttack11() ;?????? ??? ????? ???? ????? 
   StartAttack(1) 
end sub 
#++++++++++-= Auto Attack PK players only =-+++++++++++++++ 
sub StartAttack00() ;?????? ??? ????? ?????? ??,????? ? ????????????? ??????? 
   StartAttack(0) 
end sub 

sub StartAttack(status) 
   UO.Ignore("self") 
   Var FindOK=false,temp,mess,t=0,k,a 
   DIM Friend[50] 
   VAR endlist=4; ????????? ????? ? ?????? ?????? 
   Friend[0]="fdsafas" 
   Friend[1]="SENYA" 
   Friend[2]="Gurza" 
   Friend[3]="ALF" 
   Friend[4]="Flatra" 
   uo.set('finddistance','20') 
   for t=0 to 1 
      repeat 
         uo.findtype("0x019"+str(t),"-1","ground") 
         temp=0 
         for k=0 to endlist 
            if Uo.GetName("finditem")==Friend[k] and uo.findcount()<>0 then 
               UO.Ignore("finditem") 
               k=endlist 
               temp=1 
            end if 
         next 
         if temp==0 and uo.findcount()<>0 then 
            if status==0 and uo.getnotoriety("finditem")>2 then 
               UO.addobject('Enemy',uo.getserial("finditem")) 
               Uo.print ("Curent target = "+uo.getname('Enemy')) 
               uo.ignore('Enemy') 
               a = uo.getserial('finditem') 
               uo.attack( a ) 
               
               return 
            else 
               if status==1 then 
                  UO.addobject('Enemy',uo.getserial("finditem")) 
                  Uo.print("Curent target = "+uo.getname('Enemy')) 
                  uo.ignore('Enemy') 
                  a = uo.getserial('finditem') 
                  uo.attack( a ) 
                  return 
               else 
                  uo.ignore("finditem") 
               end if 
            end if 
         end if 
      until uo.findcount()==0 
      if uo.findcount()==0 then 
         UO.IgnoreReset() 
      end if 
   next 
end sub 

#-----------------Ress qlq um
sub R()
   
   
   VAR Exit=0, i, g=0
   DIM Ghost[1]
   Ghost[0]=0x0192
   Ghost[1]=0x0193
   
   
   uo.set("finddistance","12")
   For i=0 to 1
      uo.ignore('self')
      uo.findtype(Ghost[i],-1,'ground')
      if UO.findcount() > 0 then 
         UO.WaitTargetobject('finditem')
         if uo.count('0x0E29') > 50 then
            uo.usetype('0x0E29')
         else
            UO.Cast('Resurrection')
            uo.charprint("Ressucitando "+uo.getname('finditem')) 
            wait(1000)
         end if
         g=1
      end if
   next
   if g<1 then
      Uo.charprint("0x6", "Nenhum ghost encontrado")
   end if
   
end sub



Sub PassarPorCima()
   var mantle='0x402263C3' ; Se você quiser pode colocar o serial (UID) do seu mantle aqui, ou ele será encontrado pelo type, mas pelo serial (UID) é MUITO mais recomendado ;
   var typeMantle='0x0000' ; Type do seu mantle. Pode ser encontrado usando ,info e clicando no seu mantle ;
   var stamFish=10 ; 0=desabilitado >> Valor que o Highly Peculiar Fish recupera da sua stamina ;
   var stamMantle=15 ; 0=desabilitado >> Valor de dextreza que diminui quando você tira o seu mantle ;
   var stamRefresh=30 ; 0=desabilitado >> Valor que a poção Refresh recupera da sua stamina ;
   var stamTotalRefresh=70 ; 0=desabilitado >> Valor que a poção Total Refresh recupera da sua stamina ;
   var timeout
   var temFish=false
   If UO.Count('0x09CC','0x0042')>0 Then
      temFish=true
   End If
   var temMantle=false
   If (UO.GetGraphic(UO.ObjAtLayer('Robe'))==typeMantle And typeMantle<>'0x0000') Or (UO.ObjAtLayer('Robe')==mantle And mantle<>'0x00000000') Then
      mantle=UO.ObjAtLayer('Robe')
      temMantle=true
   End If
   var temRefresh=false
   If UO.Count('0x0F0E','0x0021')>0 Then
      temRefresh=true
   End If
   If UO.Stamina<UO.Dex Then
      If UO.Stamina>=UO.Dex-stamFish And temFish Then
         UO.UseType('0x09CC','0x0042')
      Else
         If UO.Stamina>=UO.Dex-stamMantle And temMantle Then
            UO.Grab(1,mantle)
         Else
            If UO.Stamina>=UO.Dex-stamMantle-stamFish And temMantle And temFish Then
               UO.Grab(1,mantle)
               UO.UseType('0x09CC','0x0042')
            Else
               If UO.Stamina>=UO.Dex-stamRefresh And temRefresh Then
                  UO.Msg('.drink Refresh')
                  UO.Msg('.drink Total Refresh')
                  ; Timer de Poções aqui! ;
               Else
                  If UO.Stamina>=UO.Dex-stamRefresh-stamFish And temRefresh And temFish Then
                     UO.Msg('.drink Refresh')
                     UO.Msg('.drink Total Refresh')
                     ; Timer de Poções aqui! ;
                     UO.UseType('0x09CC','0x0042')
                  Else
                     If UO.Stamina>=UO.Dex-stamRefresh-stamMantle And temRefresh And temMantle Then
                        UO.Msg('.drink Refresh')
                        UO.Msg('.drink Total Refresh')
                        ; Timer de Poções aqui! ;
                        UO.Grab(1,mantle)
                     Else
                        If UO.Stamina>=UO.Dex-stamRefresh-stamMantle-stamFish And temRefresh And temMantle And temFish Then
                           UO.Msg('.drink Refresh')
                           UO.Msg('.drink Total Refresh')
                           ; Timer de Poções aqui! ;
                           UO.Grab(1,mantle)
                           UO.UseType('0x09CC','0x0042')
                        Else
                           If UO.Stamina>=UO.Dex-stamTotalRefresh And temRefresh Then
                              UO.Msg('.drink Total Refresh')
                              UO.Msg('.drink Refresh')
                              ; Timer de Poções aqui! ;
                           Else
                              If UO.Stamina>=UO.Dex-stamTotalRefresh-stamFish And temRefresh And temFish Then
                                 UO.Msg('.drink Total Refresh')
                                 UO.Msg('.drink Refresh')
                                 ; Timer de Poções aqui! ;
                                 UO.UseType('0x09CC','0x0042')
                              Else
                                 If UO.Stamina>=UO.Dex-stamTotalRefresh-stamMantle And temRefresh And temMantle Then
                                    UO.Msg('.drink Total Refresh')
                                    UO.Msg('.drink Refresh')
                                    ; Timer de Poções aqui! ;
                                    UO.Grab(1,mantle)
                                 Else
                                    If UO.Stamina>=UO.Dex-stamTotalRefresh-stamMantle-stamFish And temRefresh And temMantle And temFish Then
                                       UO.Msg('.drink Total Refresh')
                                       UO.Msg('.drink Refresh')
                                       ; Timer de Poções aqui! ;
                                       UO.Grab(1,mantle)
                                       UO.UseType('0x09CC','0x0042')
                                    Else
                                       If temFish Then
                                          UO.UseType('0x09CC','0x0042')
                                       End If
                                       UO.CharPrint('0x002B','Stamina - Impossível!')
                                    End If
                                 End If
                              End If
                           End If
                        End If
                     End If
                  End If
               End If
            End If
         End If
      End If
      timeout=0
      While UO.Stamina<UO.Dex And timeout<=1000
         Wait(100)
         timeout=timeout+100
      WEnd
   End If
   If UO.Stamina>=UO.Dex Then
      UO.CharPrint('0x0048','Stamina - Pode Passar!')
      If temMantle And UO.ObjAtLayer('Robe')<>mantle Then
         timeout=0
         While UO.Stamina>=UO.Dex And timeout<=5000
            Wait(100)
            timeout=timeout+100
         WEnd
         UO.UseObject('mantle')
      End If
   Else
      UO.CharPrint('0x0058','Stamina - Verifique')
   End If
End Sub


Sub lootgold()
   var i = "0x0EED"
   UO.FindType(i,"-1","lastcontainer") 
   if uo.getquantity ('finditem') > 0 then
      UO.Grab("0","finditem")
      uo.charprint('0x08A5','Lootiou: ' + Str( uo.getquantity('finditem')) + ' Gold')
   endif 
end sub

sub GateEvil()
   uo.warmode( 0 ) ;
   IF UO.Count('0x1F14') > 0 Then
      uo.waittargettype('0x1F14') ; type que compra no vendor
      wait(180)
      uo.cast('Gate Travel')
      wait(130)
      ;if uo.count("0x1F0B","0x0592") ==0 then ;ORC VISAGE 
      ;wait(100)
      tirar3()
   end if
   wait(10)
   tirar2()
   wait(10)
   UO.Exec("useskill 'Stealth'")
   wait(20)
   uo.usetype('0x1415');PEITO /
   wait(20)
   uo.usetype('0x1416');PEITO \
   wait(20)
   uo.usetype('0x1410');ARMS /
   wait(20)
   uo.usetype('0x1417');ARMS \
   wait(20)
endsub

sub RecalEvil()
   uo.warmode( 0 ) ;
   IF UO.Count('0x1F14') > 0 Then
      uo.waittargettype('0x1F14') ;
      uo.cast('Recall')
      wait(150)
      ;if uo.count("0x1F0B","0x0592") ==0 then ;ORC VISAGE 
      ;wait(10)
      tirar3()
   end if
   wait(10)
   tirar2()
   wait(10)
   UO.Exec("useskill 'Stealth'")
   wait(20)
   uo.usetype('0x1415');PEITO /
   wait(20)
   uo.usetype('0x1416');PEITO \
   wait(20)
   uo.usetype('0x1410');ARMS /
   wait(20)
   uo.usetype('0x1417');ARMS \
   wait(20)
end sub

sub Stealth()
   ;wait(130)
   ;if uo.count("0x1F0B","0x0592") ==0 then ;ORC VISAGE 
   ;wait(10)
   tirar3()
end if
wait(10)
tirar2()
wait(10)
UO.Exec("useskill 'Stealth'")
wait(20)
uo.usetype('0x1415');PEITO /
wait(20)
uo.usetype('0x1416');PEITO \
wait(20)
uo.usetype('0x1410');ARMS /
wait(20)
uo.usetype('0x1417');ARMS \
wait(20)
endsub

sub tirar2()
   var ser, i
   DIM parte[1]
   parte[1] = "Torso"
   
   for i = 1 to 1
      if uo.ObjAtLayer(parte[i]) then
         ser = uo.getserial(uo.ObjAtLayer(parte[i]))
         repeat
            uo.moveitem(ser,'-1','backpack')
            wait(100)
         until NOT UO.ObjAtLayer(parte[i])
      endif
   next
endSub

sub tirar3()
   var ser, i
   DIM parte[1]
   
   parte[1] = "Arms"
   
   for i = 1 to 1
      if uo.ObjAtLayer(parte[i]) then
         ser = uo.getserial(uo.ObjAtLayer(parte[i]))
         repeat
            uo.moveitem(ser,'-1','backpack')
            wait(100)
         until NOT UO.ObjAtLayer(parte[i])
      endif
   next
endSub

sub stealth22()
   wait(150)
   uo.findtype(0x1415,"-1","my")
   uo.moveitem('finditem','Peito','backpack')
   wait(10)
   uo.findtype(0x1410,"-1","my")
   uo.moveitem('finditem','Peito','backpack')
   wait(10)
   uo.useskill('Stealth')
   wait (10)
   uo.usetype('0x1415')
Endif
end sub

sub attacklast()
   uo.waittargetlast()
   uo.attack()
end sub

sub usebands()
   if uo.poisoned('self') then
      uo.cast('Cure','self')
   else
      if uo.life<uo.str and uo.count('0x0E21') then
         uo.bandageself()
      endif
   endif
   uo.charprint('0x1152',uo.count('0x0E21'))
endsub

sub openbank()
   uo.set('finddistance','4')
   uo.findtype('0x0BD2','-1','ground')
   if uo.findcount() > 0 then
      uo.recall('finditem','6')
   endif
end sub

sub pot()
   var x=uo.dex
   var h=uo.str
   var m=uo.int
   if UO.Poisoned() then
      uo.useobject('cure')
      wait(150)
      uo.usetype('0x1F03')
      wait(150)
      if UO.Poisoned() then
         uo.usetype("0x0F0E","0x008F")
      end if
      goto FIM
   end if
   if uo.life < h+1 and uo.mana < m+1 and uo.Count("0x0F82","0x017F") > 0 then
      uo.usetype("0x0F82","0x017F")
      goto FIM
   end if
   if uo.life < h+1 and uo.count("0x0F82","0x0026") >0 then
      uo.usetype("0x0F82","0x0026")
      goto FIM
   end if
   if uo.mana < m+1 then
      uo.usetype("0x0F82","0x0532")
      goto FIM
   end if
   FIM:
end sub

sub AutoBands()
   Var Delay = 0, i, g=0, weapon
   While TRUE
      g=0
      If UO.Count('0x0E21') > 0 Then
         if (uo.ObjAtLayer('Lhand') == '') then
            If UO.Life < UO.Str Then
               UO.BandageSelf()
               Repeat
                  Wait(500)
                  Delay = Delay + 100
               Until UO.InJournal('Voce curou') == 1 OR Delay > 1250 OR UO.InJournal('You put the bloody') == 1
               Delay = 0
               g = 1
            End If
         end if
      Else
         UO.CharPrint('self','0x0790','Voce nao tem Bandagens.')
         Wait(10000)
      End If
      wait(50)
   wend
end sub


sub Target() 
   
   var totalFriend=10
   var temp, name, t = 0, k, a, findResult = 0      
   DIM friend[10]
   friend[0]='CoMpLeX'
   friend[1]='Pandox'
   friend[2]='The Sexy'
   friend[3]='Iguin'
   friend[4]='C o U t O'
   friend[5]='Khaleesi'
   friend[6]='Lionel Messi'
   friend[7]='xMaGj'
   friend[8]='Zlatan Ibrahimovic'
   friend[9]='ThE PoRcA'
   friend[10]='B a l l a c K'
   
   
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

sub buffskds()
   uo.cast('Reactive Armor','self')
   wait(500)
   uo.cast('Protection','self')
   wait(1000)
   uo.cast('Strength','self')
   wait(1000)
   uo.cast('Magic Reflection','self')
end sub

sub taming()
   uo.usetype ('0x0EB2')
   UO.Set('laststatus') 
   uo.usetype ('0x13F8')
   uo.waittargetlast()
end sub

sub entrar()
   uo.set('finddistance','2')
   uo.findtype("0x0ED4","-1","ground")
   if uo.findcount()>0then
      uo.recall("finditem","1")
   else
      uo.findtype("0x2100","-1","ground")
      if uo.findcount()> 0then
         uo.recall("finditem","1")
      endif
   endif
endsub
###variaveis a definir#######################
var runeB = '0x40118735' #id do rune book  ##
var numRunaM = '3' #posicao da runa da mina##
var numRunaB = '1' #posicao da runa do banco#
var peso = 69 #peso pra dar recall          #
var passos = 3     #numero de passos        #
var OreBox = '0x4010df85' #container no     #
#banco aonde vai  #
#guardar os ores  #
#############################################

Sub seed()
   var x, y
   y = right(str(uo.time()),2)
   for x = 0 to val(y)
      uo.random(8)
   next
endsub

Sub morreu()
   uo.warmode(0)
   helproom()
   esperar(uo.getX(),uo.getY())
   andarHR()
   while uo.mana < 20
      uo.useskill('Meditation')
      wait(15000)
   wend
   uo.recall(runeB,numRunaM)
   WaitForRecall()
endsub

sub andarHR()
   var aux, x
   repeat
      aux = uo.getY()
      for x = 0 to 7
         uo.press(35)
         wait(100)
      next
      checarlag()  
   until uo.getY() == aux
   repeat
      aux = uo.getX()
      for x = 0 to 7
         uo.press(36)
         wait(100)
      next
      checarlag()  
   until uo.getX() == aux
   repeat
      aux = uo.getX()
      uo.press(33)
      wait(100)
      checarlag()  
   until abs(uo.getX() - aux) > 10
   checarlag()
   pegarItens(0)
   gotoxy(5413,1203,0)
   checarlag()
   uo.press(36)
   uo.press(36)
   checarlag()
endsub

Sub esperar(myX,myY)
   repeat
      wait(500)
   until myX <> uo.getX() and myY <> uo.getY()
endsub

Sub helproom()
   uo.lclick(1032,53) #botao de help
   checarlag()
   uo.lclick(361,374) #botao da HELP ROOM
   checarlag()
   uo.lclick(787,487) #checkbox do SIM, quero ir para help room
   checarlag()
   uo.lclick(983,557) #botao de confirmar  
endsub

sub fazer_fs() ; Macro de Fazer Flame Strike Scrolls , Puxando material de 1 Container qualquer, Favor seguir as instrucoes do macro
   VAR Blank = '0x0E34'
   VAR Spider = '0x0F8D'
   VAR Sulfurous = '0x0F8C'
   VAR fs = '0x1F5F'
   uo.print('%autoload by Shakespeare')
   uo.print('Fazer FS Scroll TFG Shard')
   wait(2000)
   uo.print('Para o macro dar certo tenha Blank Scrolls, Spider Silk e Sulfurous Ash no mesmo Container.')
   wait(5000)
   UO.print('Clique no CONTAINER onde ficara os regs')
   UO.exec('addobject CONTAINER')
   while UO.targeting()
      wait(100)
   wend
   wait(1500)
   UO.print('Clique na sua BAG')
   UO.exec('addobject bagR')
   while UO.targeting()
      wait(100)
   wend
   repeat
      repeat
         UO.CancelMenu() 
         UO.AutoMenu('Seventh Circle', 'Flamestrike') 
         UO.Usetype( blank )
         wait(3800)
      until UO.count(Blank)<2 OR UO.count(Spider)<2 OR UO.count(Sulfurous)<2
      UO.SetReceivingContainer('Bag')
      UO.FindType('0x0E34',-1,'backpack')
      if UO.GetQuantity('finditem')<2 then
         UO.FindType('0x0E34','0x0000','CONTAINER') ; blank
         wait(1000)
         UO.Grab('100','finditem') 
      endif
      UO.FindType('0x0F8D',-1,'backpack')
      if UO.GetQuantity('finditem')<2 then 
         UO.FindType('0x0F8D','0x0000','CONTAINER') ; Spider Silk
         wait(1000) 
         UO.Grab('100','finditem') 
      endif
      UO.FindType('0x0F8C',-1,'backpack')
      if UO.GetQuantity('finditem')<2 then
         UO.FindType('0x0F8C','0x0000','CONTAINER') ; Sulfurous Ash
         wait(1000) 
         UO.Grab('100','finditem')
      endif
      UO.UnSetReceivingContainer()
      UO.SetReceivingContainer('CONTAINER')
      UO.FindType('0x1F5F',-1,'backpack')
      if UO.GetQuantity('finditem')>90 then
         UO.FindType('0x1F5F',-1,'backpack')
         wait(3000)
         UO.Print('Guardando os FS')
         UO.Grab('all','finditem')
         wait(3000)
      endif
      UO.UnSetReceivingContainer()
   until UO.dead()
end sub

Sub pegarItens(flag)
   dim IT[4]
   var x
   IT[0] = '0x0E85' ;pickaxe 
   IT[1] = '0x0F7B' ;bm 
   IT[2] = '0x0F86' ;mr
   IT[3] = '0x0F7A' ;bp 
   
   uo.msg('bank')
   checarlag()
   for x = 0 to 3 
      if flag == 1 then
         x = 1
         flag = 0
      endif  
      uo.findtype(IT[x],-1,'lastcontainer')
      if  x == 0 then       
         repeat  
            uo.moveitem('finditem', 'backpack')       
            wait(500) 
            uo.print(str(uo.count(IT[x])))     
         until  uo.count(IT[x]) > 0
      else
         repeat
            uo.moveitem('finditem', '2', 'backpack')  
            wait(500)
            uo.print(str(uo.count(IT[x])))     
         until  uo.count(IT[x]) > 0
      endif 
   next   
endsub

Sub checarlag()
   uo.deletejournal()
   uo.click('backpack')
   repeat
      wait(500)
   until uo.injournal('backpack')
endsub

sub LooterNew() 
   VAR i, n 
   VAR w = 2050 ; the delay after a move
   VAR razmer = 12  ; the size of the DIM 
   
   DIM Loot[12]  
   Loot[1] = '0x0F82' ; pot boost
   Loot[2] = '0x1F5F' ; fs
   Loot[3] = '0x13B1' ; arco  
   Loot[4] = '0x1C04' ; peito
   Loot[5] = '0x108A' ; RING 
   Loot[6] = '0x1415' ; peitoM
   Loot[7] = '0x0EED' ; gold
   Loot[8] = '0x1F0B'   ; mask orc
   Loot[9] = '0x1545' ; bear mask
   Loot[10] = '0x141A' ; Perna
   Loot[11] = '0x0F3F'   ; PERNA
   Loot[12] = '0x13CC'   ; peito drake leater
   
   if uo.getdistance( 'lastcontainer' ) < 3 then 
      uo.deletejournal() 
      repeat 
         uo.findtype( '-1', '-1', 'lastcontainer' )  
         n = 0 
         for i = 1 to razmer 
            if uo.getgraphic( 'finditem' ) == Loot[i] then 
               uo.moveitem( 'finditem', 'all', 'my' ) 
               wait(w) 
               if uo.injournal( 'UNSP' ) then 
                  wait(w*2) 
                  uo.deletejournal() 
               endif 
               n = 1 
               goto nextitem 
            endif          
         next 
         if n == 0 then 
            uo.ignore( 'finditem' ) 
         endif 
      nextitem: 
   until uo.findcount() == 0 
else 
   uo.print( 'The Corpse is too far' )
endif 
endsub

Sub hiding()
   while not UO.hidden()
      uo.deletejournal()
      uo.useskill('Stealth')
      while not uo.injournal('hidden|esconder') and not uo.dead()
         wait(500)
      wend
   wend
endsub

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

Sub walk()
   var px, py, dir
   var t = passos
   while t == 3
      px=UO.GetX('self')
      py=UO.GetY('self')
      dir=UO.Random(8)
      while (t >= 0)
         uo.press(dir+33)
         uo.press(dir+33)
         wait(100)
         t=t-1
      wend
      if (px == UO.GetX('self')) and (py == UO.GetY('self')) then
         t=3
      endif
   wend
endsub

Sub checarlimite()
   var a
   if (uo.getY('self') > 3298 and uo.getZ('self') == 0) then
      gotoxy(4588,3300,0)
      gotoxy(4588,3288,0)
   endif
Endsub 

Sub guardar()
   dim cor[19]
   cor[0] =  '0x0000'  ;iron
   cor[1] =  '0x00F2'  ;ceramic
   cor[2] =  '0x0750'  ;Rusty Ore
   cor[3] =  '0x060A'  ;Dull Copper Ore
   cor[4] =  '0x0590'  ;Old Copper Ore
   cor[5] =  '0x0641'  ;Copper Ore
   cor[6] =  '0x06D6'  ;Bronze Ore
   cor[7] =  '0x0770'  ;Shadow Ore
   cor[8] =  '0x0400'  ;Agapite Ore
   cor[9] =  '0x0665'  ;Rose Ore
   cor[10] =  '0x07D1'  ;Verite Ore
   cor[11] =  '0x045E'  ;Gold Ore
   cor[12] =  '0x0231'  ;Silver Ore
   cor[13] =  '0x0515'  ;Valorite Ore
   cor[14] = '0x04C2' ;blood rock
   cor[15] = '0x052D' ;mythril
   cor[16] = '0x03DF' ;chaos
   cor[17] = '0x024F' ;order
   cor[18] = '0x0455' ;black rock
   
   
   dim ORE[15]
   ORE[0] = '0x19B9' ;ore type
   ORE[1] = '0x19B8' ;ore type quando qtd == 3
   ORE[2] = '0x19BA' ;ore type quando qtd == 2
   ORE[3] = '0x19B7' ;ore type quando qtd == 1
   ORE[4] = '0x1BEF' ;ingot
   ORE[5] = '0x1BE3' ;ingot2
   ORE[6] = '0x1BF5' ;ingot3
   ORE[7] = '0x1BE9' ;ingot4
   ORE[8] = '0x0F0F' ;s saphire
   ORE[9] = '0x0F11' ;saphires
   ORE[10] = '0x0F18' ;tourmalines
   ORE[11] = '0x0F16' ;amethysts
   ORE[12] = '0x0F10' ;emeralds
   ORE[13] = '0x0F13' ;rubies
   ORE[14] = '0x0F26' ;diamonds
   var x,y
   var delay = 500 ;delay entre uma tentativa de smelt e outra
   ;um delay baixo causara muitas msg de
   ;"vc nao pode smeltar tao rapido" na tela
   ;um delay alto perdera mais tempo
   ;eu sugiro algo em torno de 200-1000
   for x = 0 to 18
      for y = 0 to 14
         uo.findtype(ORE[y],cor[x],'backpack')   
         if uo.findcount() > 0 then
            repeat 
               uo.findtype(ORE[y],cor[x],'backpack') 
               uo.moveitem('finditem','-1', OreBox) 
               repeat        
                  wait(delay) 
                  uo.print("a")
               until uo.count(ORE[y],cor[x]) == 0 or uo.findcount() == 0
            until  uo.findcount() == 0
         endif
      next
   next
endsub

Sub Banco_Recall()
   var x, flag
   while uo.mana < 20
      uo.useskill('Meditation')
      wait(15000)
   wend
   flag = 0
   repeat
      uo.recall(runeB,numRunaB)
      flag = WaitForRecall()
   until flag == 1
   checarlag()
   uo.msg('banker bank')
   checarlag()
   guardar()
   checarlag()
   pegarItens(1)
   checarlag()
   while uo.mana < 20
      uo.useskill('Meditation')
      wait(15000)
   wend
   flag = 0
   repeat
      uo.recall(runeB,numRunaM)
      flag = WaitForRecall()
   until flag == 1
endsub

Sub WaitForRecall() 
   var lastX=uo.getX(),lastY=uo.getY() 
   for var v=0 to 200 
      if abs(uo.getX()-lastX) > 100 then 
         return 1 
      end if 
      wait(200) 
   next 
   return 0 
end sub 

Sub gotoxy(x,y,prec) 
   var ld=0,ldc=0 
   var dx,dy 
   var mx,my 
   var ox,oy,mk,k 
   
   start: 
   mx=UO.GetX() 
   my=UO.GetY() 
   dx=mx-x 
   if dx<0 then 
      dx=0-dx 
   endif 
   dy=my-y 
   if dy<0 then 
      dy=0-dy 
   endif 
   if dy>dx then 
      dx=dy 
   end if 
   if dx<=prec then 
      return 
   end if 
   if not ldc then 
      ;uo.print(STR(dx)) 
   end if 
   if dx<3 then 
      mk=70 
   else 
      mk=15 
   end if 
   
   ox=mx 
   oy=my 
   for k=1 to mk 
      mx=UO.GetX() 
      my=UO.GetY() 
      if mx<>ox or my<>oy then 
         goto sdidapl 
      end if 
      wait(10) 
   next 
   sdidapl: 
   
   mx=UO.GetX() 
   my=UO.GetY() 
   dx=mx-x 
   if dx<0 then 
      dx=0-dx 
   endif 
   dy=my-y 
   if dy<0 then 
      dy=0-dy 
   endif 
   if dy>dx then 
      dx=dy 
   end if 
   
   if dx<=prec then 
      return 
   end if 
   if ld==dx then 
      ldc=ldc+1 
      if ldc>100 then 
         uo.print("Can not reach location!") 
         Stoplocation = 1    
         return 
      end if 
   else 
      ld=dx 
   end if 
   
   if mx==x then 
      if my==y then 
         return 
      endif 
      if my>y then 
         
         UO.Press(33) 
         goto start 
      endif 
      
      UO.Press(35) 
      goto start 
   end if 
   if mx<x then 
      if my>y then 
         
         UO.Press(39) 
         goto start 
      endif 
      if my==y then 
         
         UO.Press(34) 
         goto start 
      endif 
      
      UO.Press(40) 
      goto start 
   end if 
   if my<y then 
      
      UO.Press(37) 
      goto start 
   endif 
   if my==y then 
      
      UO.Press(36) 
      goto start 
   endif 
   
   UO.Press(38) 
   goto start 
end sub

sub abs(X)
   if x>0 then
      return x
   else
      return -x
endsub

sub smelt()
   dim cor[14]
   cor[0] =  '0x0000'  ;iron
   cor[1] =  '0x00F2'  ;ceramic
   cor[2] =  '0x0750'  ;Rusty Ore
   cor[3] =  '0x060A'  ;Dull Copper Ore
   cor[4] =  '0x0590'  ;Old Copper Ore
   cor[5] =  '0x0641'  ;Copper Ore
   cor[6] =  '0x06D6'  ;Bronze Ore
   cor[7] =  '0x0770'  ;Shadow Ore
   cor[8] =  '0x0400'  ;Agapite Ore
   cor[9] =  '0x0665'  ;Rose Ore
   cor[10] =  '0x07D1'  ;Verite Ore
   cor[11] =  '0x045E'  ;Gold Ore
   cor[12] =  '0x0231'  ;Silver Ore
   cor[13] =  '0x0515'  ;Valorite Ore
   
   dim ORE[4]
   ORE[0] = '0x19B9' ;ore type
   ORE[1] = '0x19B8' ;ore type quando qtd == 3
   ORE[2] = '0x19BA' ;ore type quando qtd == 2
   ORE[3] = '0x19B7' ;ore type quando qtd == 1
   var x,y
   var delay = 500 ;delay entre uma tentativa de smelt e outra
   ;um delay baixo causara muitas msg de
   ;"vc nao pode smeltar tao rapido" na tela
   ;um delay alto perdera mais tempo
   ;eu sugiro algo em torno de 200-1000
   for x = 0 to 13
      for y = 0 to 3
         uo.findtype(ORE[y],cor[x],'lastcontainer')   
         if uo.findcount() > 0 then
            repeat 
               UO.DeleteJournal()
               uo.findtype(ORE[y],cor[x],'lastcontainer') 
               uo.moveitem('finditem','1') 
               repeat        
                  wait(delay)
               until uo.count(ORE[3],cor[x]) > 0 or uo.findcount() == 0
               repeat   
                  uo.usetype(ORE[3],cor[x])     
                  wait(delay)
               until uo.count(ORE[3],cor[x]) == 0
            until  uo.findcount() == 0
         endif
      next
   next
endsub

sub Alchemy()
   uo.addobject("bau")
   while uo.targeting()
      wait(100)
   wend
   uo.useobject('bau')
   wait(100)
   uo.addobject("baug")
   while uo.targeting()
      wait(100)
   wend
   uo.useobject('baug')
   wait(100)
   uo.exec ('exec play')
end sub

sub reagson1()
   var x, aux = 0
   var qtd = 200
   var bau = '0x400BA465'
   var delay = 700
   dim items[19]
   items[0]  =  '0x0F7B,-1,200,bagR'  		;BM
   items[1]  =  '0x0F85,-1,200,bagR'  		;GS
   items[2]  =  '0x0F8C,-1,200,bagR'  		;SA
   items[3]  =  '0x0F88,-1,200,bagR'  		;NS
   items[4]  =  '0x0F8D,-1,200,bagR'  		;SS
   items[5]  =  '0x0F86,-1,200,bagR'  		;MR
   items[6]  =  '0x0F7A,-1,200,bagR'  		;BP
   items[7]  =  '0x0F84,-1,200,bagR'  		;GA
   items[8]  =  '0x0F82,0x017F,15,backpack'   	;REFILING
   items[9]  =  '0x0F82,0x0532,25,backpack'   	;MANA
   items[10] =  '0x0F82,0x0026,5,backpack'    	;LIFE
   items[11] =  '0x0F0E,0x008F,10,backpack'   	;CURE
   items[12] =  '0x0F0E,0x0022,10,backpack'   	;STAN
   items[13] =  '0x1F5F,-1,30,backpack'   	;FS
   items[14] =  '0x0E21,-1,300,backpack'  	;bands
   items[15] =  '0x0F0E,0x0480,20,backpack'   	;TOTAL MANA
   items[16] =  '0x0F0E,0x0631,10,backpack'   	;INVS
   items[17] =  '0x0F0E,0x0000,15,backpack'   	;BOTTLE
   items[18] =  '0x0F0E,0x0076,10,backpack'   	;SHIRINK
   items[19] =  '0x0F3F,0x0000,150,backpack'   	;ARROW     
   
   uo.useobject('backpack')
   uo.useobject('bagR')
   uo.useobject(bau)
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

sub autoband()
   repeat 
      uo.deletejournal()
      uo.usetype('0x0E21')
      uo.waittargetself()
      repeat 
      until uo.injournal('Voce curou') || uo.injournal('nao precisa ser') || uo.injournal('parar bandagem')
      repeat 
         wait(500)
      until uo.life < uo.str || uo.injournal('parar bandagem')
   until uo.injournal('parar bandagem')
end sub

sub reagson()
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
   items[8]  =  '0x0F82,0x017F,25,backpack'   	;REFILING
   items[9]  =  '0x0F82,0x0532,50,backpack'   	;MANA
   items[10] =  '0x0F82,0x0026,50,backpack'    	;LIFE
   items[11] =  '0x0F0E,0x008F,15,backpack'   	;CURE
   items[12] =  '0x0F0E,0x0022,25,backpack'   	;STAN
   items[13] =  '0x1F5F,-1,55,backpack'   	;FS
   items[14] =  '0x0E21,-1,100,backpack'  	;bands
   items[15] =  '0x0F0E,0x0480,10,backpack'   	;TOTAL MANA
   items[16] =  '0x0F0E,0x0001,7,backpack'   	;INVS
   items[17] =  '0x0F0E,0x0000,20,backpack'   	;BOTTLE
   items[18] =  '0x0F0E,0x0076,3,backpack'   	;SHIRINK
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

Sub horsekillas() 
   uo.waittargetobject('lasttarget')   
   uo.waittargetobject('laststatus')   
   uo.msg('all kill')            
End Sub

Sub lgt() 
   uo.waittargetobject('lasttarget')   
   uo.waittargetobject('laststatus')   
   uo.cast('Lightning')            
End Sub


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


Sub Magicarrow() 
   uo.waittargetobject('lasttarget')   
   uo.waittargetobject('laststatus')   
   uo.cast('Magic Arrow')            
End Sub


Sub clum() 
   uo.waittargetobject('lasttarget')   
   uo.waittargetobject('laststatus')   
   uo.cast('Clumsy')            
End Sub


Sub abrebody()
   uo.usefromground('0x2006')
End Sub


sub armor2()
   var bag = '0x0E76'
   var delay = 700
   var cnt = 0    
   var total = 0   
   var x,y,qtdbag,bagserial
   
   DIM item[14]
   item[0] = '0x13CC,-1' ; wyrm
   item[1] = '0x13CB,-1' ; wyrm
   item[2] = '0x13C5,-1' ; wyrm
   item[3] = '0x13C6,-1' ; wyrm
   item[4] = '0x13C7,-1' ; wyrm 
   item[5] = '0x1F03,-1' ; taylor
   item[6] = '0x1541,-1' ; taylor
   item[7] = '0x154B,-1' ; taylor
   item[8] = '0x1415,-1' ; plate peito
   item[9] = '0x1411,-1' ; plate
   item[10] = '0x1404,-1' ; armas
   item[11] = '0x108A,-1' ; anel
   item[12] = '0x0EB2,-1' ; arpa 
   item[13] = '0x13B1,-1' ; bow
   item[14] = '0x0F45,-1' ; axe
   
   total=14
   uo.ignore('backpack')
   
   uo.ignorereset()
   uo.useobject('bauarmor')
   wait(delay)
   uo.findtype(bag,'-1','bauarmor')
   qtdbag = uo.FindCount() - 1
   
   for x = 0 to qtdbag
      uo.findtype(bag,'-1','bauarmor')      
      bagserial = uo.getserial('finditem')
      uo.useobject(bagserial)
      uo.ignore('finditem')      
      wait(delay)
      for x = 0 to total
         uo.findtype(GetWord(item[x],1,','),GetWord(item[x],2,','),bagserial)
         if uo.getquantity('finditem') > 0 then
            uo.moveitem('finditem',1, 'backpack')
            wait(delay)
            uo.useobject('finditem')
            cnt = cnt + 1
            if cnt > total then
               return
            end if
         endif       
      next      
   next   
end sub

sub curerobe()
   uo.useobject('cure')
   wait(200)
   uo.usetype ('0x2683') 
end sub

sub curerobe1()
   uo.useobject('cure')
   wait(200)
   uo.usetype ('0x1F03') 
end sub

sub AutoBands1()
   var j
   while 1<2 
      while not uo.dead()
         if uo.life < uo.str and not uo.poisoned('self') then 
            uo.bandageself()
            uo.exec('exec armas')
            uo.deletejournal()
            j=0
            repeat
               j=j+2
               wait(200)
            until uo.injournal('Voce curou') or uo.injournal('Voce nao pode') or uo.injournal('Voce perde a concentracao') or j>=50
         endif
         wait(200)
      wend
      wait(500)
   wend
end sub

sub tab()
   while true
      wait(500)
      uo.warmode(0) 
   wend
end sub

sub targetblue()  
   var currenttarget = 0x00000000
   var notoriety = 0,refind, t=0, i=0, check=0
   
   DIM amigo[27]
   amigo[0]='Deuriney'
   amigo[1]='Matrix'
   amigo[2]='M e R e N d A'
   amigo[3]='Acrobatic'
   amigo[4]='Bashar'
   amigo[5]='Kumba'
   amigo[6]='MarlborO'
   amigo[7]='Sullivan Dane'
   amigo[8]='poisoN'
   amigo[9]='K a l i s H'
   amigo[10]='SubSiX'
   amigo[11]='M e R e N d A'
   amigo[12]='brg00d'
   amigo[13]='Rapar1igaXp'
   amigo[14]='Iohama Bastrovis'
   amigo[15]='wHit1e Snake'
   amigo[16]='O M1ito'
   amigo[17]='Boh1ler'
   amigo[18]='Hyd1raX'
   amigo[19]='Tio Ryze'
   amigo[20]='Apostolo'
   amigo[21]='Davy Jones'
   amigo[22]='LithiuN'
   amigo[23]='B u D'
   amigo[24]='Zamorano'
   amigo[25]='Giardia Lamblia'
   amigo[26]='ThikaChu'
   amigo[27]='Cardiac'
   
   inicio:
   UO.Ignore('self')
   UO.Set("finddistance","15")   
   uo.findtype(0x0190,'-1','ground')
   
   if uo.findcount() > 0 then
      currenttarget = uo.getserial('finditem')
      for t=0 to 27
         if uo.getnotoriety('finditem') == 1 then
            uo.ignore('finditem')
         nexttarget()
         return
      else
         if (uo.getname('finditem') == amigo[t]) then  
            uo.ignore('finditem')
         nexttarget()
         return
      endif 
   endif        
next        
UO.AddObject('alvo',currenttarget)  
UO.Set('quiet',0)
uo.print("[TARGET] [" + uo.getname("finditem") + "]) " + str(UO.GetHP("finditem")) + "/100")
uo.attack(currenttarget)
uo.ignore(currenttarget)
return 0
else
uo.findtype(0x0191, '-1', 'ground')
if uo.findcount() > 0 then
   currenttarget = uo.getserial('finditem')
   for t=0 to 20
      if uo.getnotoriety('finditem') == 1 then
         uo.ignore('finditem')
      nexttarget()
      return
   else
      if uo.getname('finditem') == amigo[t] then  
         uo.ignore('finditem')
         goto inicio
      endif 
   endif     
next      
UO.AddObject('alvo',currenttarget)   
UO.Set('quiet',0)
uo.print("[TARGET] [" + uo.getname("finditem") + "]) " + str(UO.GetHP("finditem")) + "/100")
uo.attack(currenttarget)
uo.ignore(currenttarget)
return 0
endif
if refind == 0 then
UO.IgnoreReset()
refind=1
goto inicio
endif
UO.CharPrint('self', 0x000, 'Nenhum target encontrado')
uo.ignorereset()
endsub
