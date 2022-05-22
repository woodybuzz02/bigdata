const beforeText = document.getElementById('before_text');
const afterText = document.getElementById('after_text');
beforeText.onkeyup = function() {
    afterText.textContent = beforeText.value;
}
