##=======================================================
sub Taming() ;
   var count=0
   uo.msg('All Release')
   wait(200)
   uo.print('Tenha uma Harpa na Bag')
   wait(500)
   UO.DeleteJournal()
   while NOT UO.Dead()
      UO.DeleteJournal()
      UO.WaitTargetObject('animal')
      UO.UseType('0x0EB2')
      repeat
         wait(100)
      until UO.InJournal('aceita voce|falhou|play')
      If Uo.InJournal('aceita voce|falhou') Then
         UO.Say('All release')
      Endif
   wend
end sub
##=======================================================    
sub Tinkering() ; Tinkering
   while NOT UO.Dead()
      UO.DeleteJournal()
      UO.UseType('0x1EBC')
      uo.waitmenu('Tinkering','Parts','Parts','clock parts')
      repeat
         wait(100)
      until UO.InJournal('put|falhou')
   wend
end sub
##=======================================================    
sub BS() ; Blacksmithing
   while NOT UO.Dead()
      UO.DeleteJournal()
      UO.UseType('0x1BEF')
      uo.waitmenu('Blacksmithing','Shaped Iron')
      repeat
         wait(100)
      until UO.InJournal('put|falhou')
   wend
end sub
##======================================================= 
Sub Tailor()  ; Tailoring
   var sewing = '0x0F9D'
   var clothbox = '0x153D'
   var cloth = '0x175D'
   var a = 0                                    
   UO.AddObject('bau')
   While UO.Targeting()
      Wait(300)
   Wend
   While Not UO.Dead()
      If UO.Count('0x153D') >= 1 Then
         # uo.findtype('clothbox','-1','backpack')
         #UO.MoveItem('finditem','-1','bau')
         uo.waittargettype('0x153D')
         uo.useobject('tesoura')
         wait(500)
      End If
      If UO.Count(cloth) <= 10 Then
         uo.useobject('bau')
         wait(500)
         UO.FindType(cloth,'0','lastcontainer')
         UO.MoveItem(finditem,'500','backpack')
         Wait(500)
      End If
      UO.DeleteJournal()
      UO.WaitMenu('Cloth','Misc.','Misc.','full apron')
      UO.UseType(sewing)
      UO.WaitTargetType(0x175D)
      Repeat
         Wait(100)
         a = a + 1
      Until UO.InJournal('put|falhou') OR a > 250
      a = 0
   Wend
End Sub

##======================================================= 

sub separar()
   uo.Print('Coloque um bau na bag e coloque os ores dentro dele')
   wait(2000)
   uo.Print('Selecione o bau')
   UO.AddObject('bau')
   While UO.Targeting()
      Wait(300)
   Wend
   While Not UO.Dead()
      uo.useobject('bau')
      UO.FindType('0x19B9','-1','lastcontainer')
      Wait(300)
      esperarAtraso()
      UO.MoveItem(finditem,'1','backpack')
      Wait(3000)
      uo.usetype('0x19B7')
   Wend
endsub 

##======================================================= 
sub resist()
   var mana = 20 #colocar aqui a quantidade de mana necessaria para soltar a magia.
   uo.Print('Selecione o Bau onde estao os reagentes')
   wait(2000)
   UO.AddObject('bau')
   While UO.Targeting()
      Wait(200)
   Wend
   uo.Print('Selecione o alvo em que voce castara a magia')
   wait(2000)
   UO.AddObject('alvo')
   While UO.Targeting()
      Wait(300)
   Wend
   UO.SaveConfig()
   while not uo.dead()
      pegarreag()
      if uo.mana >= mana then
         uo.waittargetobject('alvo')
         uo.cast('Mana Drain')
         wait(4000)
      else
         UO.DeleteJournal()
         UO.UseSkill('Meditation')
         Repeat
            wait(100)
         Until UO.InJournal('falh|canc|completa|fail') or UO.Mana == Uo.Int
      endif
   wend
endsub
##======================================================= 

