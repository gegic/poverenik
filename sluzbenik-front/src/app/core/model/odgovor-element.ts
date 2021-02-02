export interface OdgovorElement {
  _declaration: {
    _attributes: {
      version: '1.0',
      encoding: 'utf-8'
    }
  };

  'odgovor-izjasnjenje': {
    _text: string,
    _attributes: {
      'id-zalbe': string,
      'tip-zalbe': string
    }
  };
}
