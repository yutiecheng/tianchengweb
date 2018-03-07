---中文姓名---
    this.verifyChineseName = function(chinesename) {
		if (chinesename == undefined || chinesename == null || chinesename == "") { //判断是否为空
			return false;
		}
		chinesename = chinesename.replace(/(^\s*)|(\s*$)/g, ""); // 去掉前后空格
		// 汉族姓名验证
		var regChinese = /^([\u4E00-\uFA29]|[\uE7C7-\uE7F3]){1,}$/;
		// 汉族和少数名族姓名验证
		var regChina = /^([\u4E00-\uFA29]|[\uE7C7-\uE7F3]|[\u00B7]){1,}$/;
		var count; // 统计\u00B7出现的次数
		if (chinesename.indexOf("\u00B7") == -1) { //不含点分隔符,则用regChinese
			return regChinese.test(chinesename);
		}
		//少数民族·分隔符不能置于位首和位尾
		if (chinesename.indexOf("\u00B7") == 0 || chinesename.lastIndexOf("\u00B7") == chinesename.length -1) {
			return false;
		}
		for (var i = 0; i < chinesename.length; i++) {
			if (chinesename[i] == "\u00B7") {
				count++;
			}
		}
		if (count == chinesename.length) {
			return false;
		}
		return regChina.test(chinesename);
			
	};
	
	this.verifyChineseStrict = function(chinesename)	//扩展校验姓名
	{
		//动态的ucMatcher
		var ucMatcher = $('#uncommon_character_matcher').val();
		if (chinesename == undefined || chinesename == null || chinesename == "") //判断是否为空
		{ 
			return false;
		}
		//chinesename = chinesename.replace(/(^\s*)|(\s*$)/g, ""); // 去掉前后空格
		
		//if( chinesename == "") return false;
		eval('var regChinese = /^[\\u4e00-\\u9fa5'+ucMatcher+']{1,}[\\u00B7]?[\\u4e00-\\u9fa5'+ucMatcher+']{1,}$/;');
//		var regChinese = /^[\u4e00-\u9fa5]{1,}[\u00B7]?[\u4e00-\u9fa5]{1,}$/;// 汉族姓名验证

		return regChinese.test(chinesename);
	};
