function dragData (  config ) {
  var showItemNum = config.showItemNum  || 3,
      $cont  = config.$dragCont  ||  $(".drag-cont") ,
      $displayer = config.$displayer || $('.drag-dispalyer'),
      defItem = config.defItem || 0,
      dataArr = config.dataArr ||
               ["<div>00</div>",
                '<div>01</div>',
                '<div>02</div>',
                '<div>03</div>',
                '<div>04</div>',
                '<div>05</div>',
                '<div>06</div>',
                '<div>07</div>',
                '<div>08</div>',
                '<div>09</div>',
                '<div>10</div>',
                '<div>11</div>',
                '<div>12</div>']
  var dy, offy, resultOffy  
  //初始化元素 为空时使用arr
  var nullReg = /^\s+$/
  if ( $cont.text() === "" || nullReg.test( $cont.text() )){
    for (var i = 0; i < dataArr.length; i++) {  
      var newItem =    dataArr[i]
      $cont.append( newItem )
    };
  }else {
    dataArr = $cont.children()
  }
  //初始化数据
  $cont.children().addClass('drag-item')
  $item = $('.drag-item')
  // .slice()
  function emptyPx (str) {
    return +str.slice(0,str.lastIndexOf('px'))
  }
  $itemH = $item.height()
         var pt=  emptyPx ( $item.css('paddingTop')  )
         var pb=   $item.css('padding') 
         var mt=  emptyPx ( $item.css('marginTop') )
         var mb= emptyPx ( $item.css('marginBottom') )
  if( showItemNum < 3){ showItemNum = 3 }
  $cont.height( $itemH * ( dataArr.length +2  ) )
  var $contH = $cont.height()
  $cont[0].style.padding = $itemH + "px 0";
  $displayer.height( $itemH * showItemNum )
  //初始位置
  $cont.css({ 
    "-webkit-transform": "translatey("+ -defItem * $itemH +"px)",
           ' transform': "translatey("+ -defItem * $itemH +"px)"
  })
  dy = -defItem * $itemH
  offy = -defItem * $itemH 
  resultOffy = -defItem * $itemH


  //触摸事件监听
  touch.on($cont[0], 'touchstart', function(ev){
    ev.preventDefault();
  });
  touch.on($cont[0], 'drag', function(ev){
    dy = dy || 0;
    offy = dy + ev.y;
    resultOffy = Math.round( offy / $itemH ) * $itemH
    if(  resultOffy > 0){
      dy = 0
      offy = 0 
      resultOffy = 0
    }
    var tranH = -$contH+$itemH*showItemNum

    if( resultOffy < tranH){
      dy = tranH
      offy = tranH
      resultOffy = tranH
    }
    $cont.css({
      "-webkit-transform": "translatey("+ offy +"px)",
             ' transform': "translatey("+ offy +"px)"
    })
  });
  touch.on($cont[0], 'dragend', function (ev) {
    return touchtop(ev)
  });
  function touchtop (ev) {
    dy += ev.y;
    defItem = Math.abs( resultOffy / $itemH ) 
    $cont.css({
      "-webkit-transform": "translatey("+ resultOffy +"px)",
             ' transform': "translatey("+ resultOffy +"px)"
    })
  }
  var getdefItem = function () {
    return defItem
  }
  var getDragId = function () {
    return $(dataArr[defItem] ).data( 'drag-id')
  }
  return {
    RstItem:getdefItem,
    dragId:getDragId
  }
}