class ViewPDFBlot extends Quill.import('blots/embed')  {
    static blotName = 'view-pdf';
    static tagName = 'a';
    static className = 'view-pdf';
    
    static create(value) {
        const node = super.create(value);
        node.innerText = 'View PDF';
        node.href = value.link;
        node.target = '_blank';
        return node;
    }
    
    static value(node) {
        return { link: node.getAttribute('href') };
    }
}
ViewPDFBlot.blotName = 'view-pdf';
ViewPDFBlot.tagName = 'a';
ViewPDFBlot.className = 'view-pdf';

Quill.register(ViewPDFBlot);