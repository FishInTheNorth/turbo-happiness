(function($) {
    'use strict';
    $(function() {

        $('[data-toggle="expansionPanel"]').on('click', function() {
            $('#' + $(this).attr("target-panel")).toggleClass('expanded');
        });

        /* Dropdown */
        $('[data-toggle="dropdown"]').on('click', function() {
            var menuEl = document.querySelector('#' + $(this).attr("toggle-dropdown"));
            var menu = new mdc.menu.MDCSimpleMenu(menuEl);
            menu.open = !menu.open;
        });

        mdc.autoInit();

        /* Select menu */
        var MDCSelect = mdc.select.MDCSelect;
        if ($('#hero-js-select').length) {
            var heroSelect = document.getElementById('hero-js-select');
            var heroSelectComponent = new mdc.select.MDCSelect(heroSelect);
        }
        /* Select menu */
        var MDCSelect = mdc.select.MDCSelect;
        if ($('#hero-js-select1').length) {
            var heroSelect = document.getElementById('hero-js-select1');
            var heroSelectComponent = new mdc.select.MDCSelect(heroSelect);
        }

        /* text field */
        if ($('#tf-box-example').length) {
            var tfEl = document.getElementById('tf-box-example');
            var tf = new mdc.textField.MDCTextField(tfEl);
        }
        if ($('#demo-tf-box-wrapper').length) {
            var wrapper = document.getElementById('demo-tf-box-wrapper');
        }
        if ($('#tf-box-leading-example').length) {
            var tfBoxLeadingEl = document.getElementById('tf-box-leading-example');
            var tfBoxLeading = new mdc.textField.MDCTextField(tfBoxLeadingEl);
        }
        if ($('#demo-tf-box-leading-wrapper').length) {
            var wrapperBoxLeading = document.getElementById('demo-tf-box-leading-wrapper');
        }
        if ($('#tf-outlined-example').length) {
            var tfEl = document.getElementById('tf-outlined-example');
            var tf = new mdc.textField.MDCTextField(tfEl);
        }
        if ($('#demo-tf-outlined-wrapper').length) {
            var wrapper = document.getElementById('demo-tf-outlined-wrapper');
        }
        /* text field1 */
        if ($('#tf-box-example1').length) {
            var tfEl = document.getElementById('tf-box-example1');
            var tf = new mdc.textField.MDCTextField(tfEl);
        }
        if ($('#demo-tf-box-wrapper1').length) {
            var wrapper = document.getElementById('demo-tf-box-wrapper1');
        }
        if ($('#tf-box-leading-example1').length) {
            var tfBoxLeadingEl = document.getElementById('tf-box-leading-example1');
            var tfBoxLeading = new mdc.textField.MDCTextField(tfBoxLeadingEl);
        }
        if ($('#demo-tf-box-leading-wrapper1').length) {
            var wrapperBoxLeading = document.getElementById('demo-tf-box-leading-wrapper1');
        }
        if ($('#tf-outlined-example1').length) {
            var tfEl = document.getElementById('tf-outlined-example1');
            var tf = new mdc.textField.MDCTextField(tfEl);
        }
        if ($('#demo-tf-outlined-wrapper1').length) {
            var wrapper = document.getElementById('demo-tf-outlined-wrapper1');
        }
    });
    /* text field2 */
    if ($('#tf-box-example2').length) {
        var tfEl = document.getElementById('tf-box-example2');
        var tf = new mdc.textField.MDCTextField(tfEl);
    }
    if ($('#demo-tf-box-wrapper2').length) {
        var wrapper = document.getElementById('demo-tf-box-wrapper2');
    }
    if ($('#tf-box-leading-example2').length) {
        var tfBoxLeadingEl = document.getElementById('tf-box-leading-example2');
        var tfBoxLeading = new mdc.textField.MDCTextField(tfBoxLeadingEl);
    }
    if ($('#demo-tf-box-leading-wrapper2').length) {
        var wrapperBoxLeading = document.getElementById('demo-tf-box-leading-wrapper2');
    }
    if ($('#tf-outlined-example2').length) {
        var tfEl = document.getElementById('tf-outlined-example2');
        var tf = new mdc.textField.MDCTextField(tfEl);
    }
    if ($('#demo-tf-outlined-wrapper2').length) {
        var wrapper = document.getElementById('demo-tf-outlined-wrapper2');
    }
    /* text field3 */
    if ($('#tf-box-example3').length) {
        var tfEl = document.getElementById('tf-box-example3');
        var tf = new mdc.textField.MDCTextField(tfEl);
    }
    if ($('#demo-tf-box-wrapper3').length) {
        var wrapper = document.getElementById('demo-tf-box-wrapper3');
    }
    if ($('#tf-box-leading-example3').length) {
        var tfBoxLeadingEl = document.getElementById('tf-box-leading-example3');
        var tfBoxLeading = new mdc.textField.MDCTextField(tfBoxLeadingEl);
    }
    if ($('#demo-tf-box-leading-wrapper3').length) {
        var wrapperBoxLeading = document.getElementById('demo-tf-box-leading-wrapper3');
    }
    if ($('#tf-outlined-example3').length) {
        var tfEl = document.getElementById('tf-outlined-example3');
        var tf = new mdc.textField.MDCTextField(tfEl);
    }
    if ($('#demo-tf-outlined-wrapper3').length) {
        var wrapper = document.getElementById('demo-tf-outlined-wrapper3');
    }
    /* text field4 */
    if ($('#tf-box-example4').length) {
        var tfEl = document.getElementById('tf-box-example4');
        var tf = new mdc.textField.MDCTextField(tfEl);
    }
    if ($('#demo-tf-box-wrapper4').length) {
        var wrapper = document.getElementById('demo-tf-box-wrapper4');
    }
    if ($('#tf-box-leading-example4').length) {
        var tfBoxLeadingEl = document.getElementById('tf-box-leading-example4');
        var tfBoxLeading = new mdc.textField.MDCTextField(tfBoxLeadingEl);
    }
    if ($('#demo-tf-box-leading-wrapper4').length) {
        var wrapperBoxLeading = document.getElementById('demo-tf-box-leading-wrapper4');
    }
    if ($('#tf-outlined-example4').length) {
        var tfEl = document.getElementById('tf-outlined-example4');
        var tf = new mdc.textField.MDCTextField(tfEl);
    }
    if ($('#demo-tf-outlined-wrapper4').length) {
        var wrapper = document.getElementById('demo-tf-outlined-wrapper4');
    }
    /* text field5*/
    if ($('#tf-box-example5').length) {
        var tfEl = document.getElementById('tf-box-example5');
        var tf = new mdc.textField.MDCTextField(tfEl);
    }
    if ($('#demo-tf-box-wrapper5').length) {
        var wrapper = document.getElementById('demo-tf-box-wrapper5');
    }
    if ($('#tf-box-leading-example5').length) {
        var tfBoxLeadingEl = document.getElementById('tf-box-leading-example5');
        var tfBoxLeading = new mdc.textField.MDCTextField(tfBoxLeadingEl);
    }
    if ($('#demo-tf-box-leading-wrapper5').length) {
        var wrapperBoxLeading = document.getElementById('demo-tf-box-leading-wrapper5');
    }
    if ($('#tf-outlined-example5').length) {
        var tfEl = document.getElementById('tf-outlined-example5');
        var tf = new mdc.textField.MDCTextField(tfEl);
    }
    if ($('#demo-tf-outlined-wrapper5').length) {
        var wrapper = document.getElementById('demo-tf-outlined-wrapper5');
    }
    /* text field6*/
    if ($('#tf-box-example6').length) {
        var tfEl = document.getElementById('tf-box-example6');
        var tf = new mdc.textField.MDCTextField(tfEl);
    }
    if ($('#demo-tf-box-wrapper6').length) {
        var wrapper = document.getElementById('demo-tf-box-wrapper6');
    }
    if ($('#tf-box-leading-example6').length) {
        var tfBoxLeadingEl = document.getElementById('tf-box-leading-example6');
        var tfBoxLeading = new mdc.textField.MDCTextField(tfBoxLeadingEl);
    }
    if ($('#demo-tf-box-leading-wrapper6').length) {
        var wrapperBoxLeading = document.getElementById('demo-tf-box-leading-wrapper6');
    }
    if ($('#tf-outlined-example6').length) {
        var tfEl = document.getElementById('tf-outlined-example6');
        var tf = new mdc.textField.MDCTextField(tfEl);
    }
    if ($('#demo-tf-outlined-wrapper6').length) {
        var wrapper = document.getElementById('demo-tf-outlined-wrapper6');
    }
    /* text field7*/
    if ($('#tf-box-example7').length) {
        var tfEl = document.getElementById('tf-box-example7');
        var tf = new mdc.textField.MDCTextField(tfEl);
    }
    if ($('#demo-tf-box-wrapper7').length) {
        var wrapper = document.getElementById('demo-tf-box-wrapper7');
    }
    if ($('#tf-box-leading-example7').length) {
        var tfBoxLeadingEl = document.getElementById('tf-box-leading-example7');
        var tfBoxLeading = new mdc.textField.MDCTextField(tfBoxLeadingEl);
    }
    if ($('#demo-tf-box-leading-wrapper7').length) {
        var wrapperBoxLeading = document.getElementById('demo-tf-box-leading-wrapper7');
    }
    if ($('#tf-outlined-example7').length) {
        var tfEl = document.getElementById('tf-outlined-example7');
        var tf = new mdc.textField.MDCTextField(tfEl);
    }
    if ($('#demo-tf-outlined-wrapper7').length) {
        var wrapper = document.getElementById('demo-tf-outlined-wrapper7');
    }
    /* text field8*/
    if ($('#tf-box-example8').length) {
        var tfEl = document.getElementById('tf-box-example8');
        var tf = new mdc.textField.MDCTextField(tfEl);
    }
    if ($('#demo-tf-box-wrapper8').length) {
        var wrapper = document.getElementById('demo-tf-box-wrapper8');
    }
    if ($('#tf-box-leading-example8').length) {
        var tfBoxLeadingEl = document.getElementById('tf-box-leading-example8');
        var tfBoxLeading = new mdc.textField.MDCTextField(tfBoxLeadingEl);
    }
    if ($('#demo-tf-box-leading-wrapper8').length) {
        var wrapperBoxLeading = document.getElementById('demo-tf-box-leading-wrapper8');
    }
    if ($('#tf-outlined-example8').length) {
        var tfEl = document.getElementById('tf-outlined-example8');
        var tf = new mdc.textField.MDCTextField(tfEl);
    }
    if ($('#demo-tf-outlined-wrapper8').length) {
        var wrapper = document.getElementById('demo-tf-outlined-wrapper8');
    }
})(jQuery);