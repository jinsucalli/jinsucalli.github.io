
function ImageViewer() {
    var IMAGE_MAX_WIDTH = 150, IMAGE_MAX_HEIGHT = 150;
    var IMAGE_EXTENSION_TYPES = ['bmp', 'jpg', 'jpeg', 'gif', 'png'];

    // 업로드하는 사용자의 이미지를 미리보기합니다.
    // inputID : form의 input 태그 아이디입니다.
    // imageID : 입력 화면에 미리보기에 이용할 기본 이미지가 있어야합니다. (기본이미지와 사용자 업로드 이미지 대체를 통해 미리보기)
    function preview(inputID, imageID) {
        var inputField = document.getElementById(inputID);
        var source = inputField.value;
        var ext = source.substring( source.lastIndexOf(".") + 1, source.length ).toLowerCase();
        for (var i=0; i<IMAGE_EXTENSION_TYPES.length; i++ ) {
            if ( IMAGE_EXTENSION_TYPES[i] == ext )
                break;
        }
        
        if( i == IMAGE_EXTENSION_TYPES.length ) {
            alert( '지원하지 않는 이미지 형식입니다. 지원 형식:\n\n' + IMAGE_EXTENSION_TYPES.join(', ') );
            return;
        }

        // 브라우저 검사하여 실제 이미지 경로 찾기
        var ua = window.navigator.userAgent;
        var localImagePath;
        if (ua.indexOf("MSIE") > -1) {
            if (source.indexOf("\\fakepath\\") < 0) {
                localImagePath = source;
            } else {
                inputField.select();
                localImagePath = document.selection.createRange().text.toString();
                inputField.blur();
            }

        } else {
            if (ua.indexOf("Firefox/3") > -1) {
                localImagePath = inputField.files.item(0).getAsDataURL();
            } else {
                localImagePath = 'file://' + source;
            }
        }
        
        // 이미지 사이즈 조정
        var uploadImage = new Image();
        uploadImage.src = localImagePath;

        var x = parseInt(uploadImage.width);
        var y = parseInt(uploadImage.height);
        if (x > IMAGE_MAX_WIDTH) {
            y *= IMAGE_MAX_WIDTH / x;
            x = IMAGE_MAX_WIDTH;
        }

        if ( y > IMAGE_MAX_HEIGHT ) {
            x *= IMAGE_MAX_HEIGHT / y;
            y = IMAGE_MAX_HEIGHT;
        }

        if( x == 0 || y == 0 ) {
            x = IMAGE_MAX_WIDTH;
            y = IMAGE_MAX_HEIGHT;
        }

        // 이미지 교체
        var targetImage = document.getElementById(imageID);
        targetImage.style.display = ( x < 1 || y < 1 ) ? 'none' : '';
        targetImage.src = uploadImage.src;
        targetImage.width = x;
        targetImage.height = y;

    } this.preview = preview;
}
